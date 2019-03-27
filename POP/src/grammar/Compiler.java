package grammar;

import declaration.*;
import declaration.ListenerDeclaration;
import logic.*;
import main.Tokenizer;
import operator.*;
import operator.Number;
import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import statement.*;
import statement.VarDeclaration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compiler implements programListener {
    private Block currentBlock = null;
    private HashMap<ParserRuleContext, Operator> exprValues;
    private HashMap<ParserRuleContext, LogicOperator> logExprValues;
    private HashMap<ParserRuleContext, Block> nestedBlocks;
    private ArrayList<Block> blockStack;

    public Compiler() {

        exprValues = new HashMap<ParserRuleContext, Operator>();
        logExprValues = new HashMap<ParserRuleContext, LogicOperator>();
        nestedBlocks = new HashMap<ParserRuleContext, Block>();
    }

    public Block getCurrentBlock() {
        return currentBlock;
    }

    @Override
    public void enterPrule(programParser.PruleContext ctx) {
        blockStack = new ArrayList<Block>();
    }

    @Override
    public void exitPrule(programParser.PruleContext ctx) {

    }

    @Override
    public void enterBlock(programParser.BlockContext ctx) {
        Block b = currentBlock;

        currentBlock = new Block();
        currentBlock.setSuperBlock(b);
        if (b != null) b.setSubBlock(currentBlock);
        blockStack.add(currentBlock);

        nestedBlocks.put(ctx, currentBlock);
    }

    @Override
    public void exitBlock(programParser.BlockContext ctx) {
        blockStack.remove(blockStack.size() - 1);
        if (currentBlock.getSuperBlock() != null) currentBlock = currentBlock.getSuperBlock();
    }

    @Override
    public void enterStatement(programParser.StatementContext ctx) {
    }

    @Override
    public void exitStatement(programParser.StatementContext ctx) {
    }

    @Override
    public void enterMapdecl(programParser.MapdeclContext ctx) {
    }

    @Override
    public void exitMapdecl(programParser.MapdeclContext ctx) {
        currentBlock.addDeclaration(new MapDeclaration(ctx.VARIABLE().getText()));
        currentBlock.addStatement(new VarDeclaration(ctx.VARIABLE().getText()));
    }

    @Override
    public void enterBooldecl(programParser.BooldeclContext ctx) {
    }

    @Override
    public void exitBooldecl(programParser.BooldeclContext ctx) {
        currentBlock.addDeclaration(new BooleanDeclaration(ctx.VARIABLE().getText()));
        currentBlock.addStatement(new VarDeclaration(ctx.VARIABLE().getText()));
    }

    @Override
    public void enterDoubledecl(programParser.DoubledeclContext ctx) {
    }

    @Override
    public void exitDoubledecl(programParser.DoubledeclContext ctx) {
        currentBlock.addDeclaration(new DoubleDeclaration(ctx.VARIABLE().getText()));
        currentBlock.addStatement(new VarDeclaration(ctx.VARIABLE().getText()));
    }

    @Override
    public void enterTextdecl(programParser.TextdeclContext ctx) {
    }

    @Override
    public void exitTextdecl(programParser.TextdeclContext ctx) {
        currentBlock.addDeclaration(new TextDeclaration(ctx.VARIABLE().getText()));
        currentBlock.addStatement(new VarDeclaration(ctx.VARIABLE().getText()));
    }

    @Override
    public void enterParameterdecl(programParser.ParameterdeclContext ctx) {
    }

    @Override
    public void exitParameterdecl(programParser.ParameterdeclContext ctx) {
    }

    @Override
    public void enterFundecl(programParser.FundeclContext ctx) {
    }

    @Override
    public void exitFundecl(programParser.FundeclContext ctx) {
        SubcallDeclaration d;
        ArrayList<Declaration> parameters = new ArrayList<Declaration>();
        List<programParser.ParameterdeclContext> pdcl = ctx.parameterdecl();

        if (ctx.PROCDECL() != null) {
            d = new ProcDeclaration(ctx.VARIABLE().getText());
        }
        else if (ctx.FUNCTIONDECL() != null) {
            if (ctx.returntype().BOOLDECL() != null) {
                d = new FunctionBoolDeclaration(ctx.VARIABLE().getText());
            }
            else if (ctx.returntype().DOUBLEDECL() != null) {
                d = new FunctionDoubleDeclaration(ctx.VARIABLE().getText());
            }
            else if (ctx.returntype().MAPDECL() != null) {
                d = new FunctionMapDeclaration(ctx.VARIABLE().getText());
            }
            else if (ctx.returntype().TEXTDECL() != null) {
                d = new FunctionTextDeclaration(ctx.VARIABLE().getText());
            }
            else d = null;
        }
        else if (ctx.LISTENERDECL() != null) {
            d = new ListenerDeclaration(ctx.VARIABLE().getText());
            ((ListenerDeclaration) d).resetEnv();
        }
        else d = null;

        for (programParser.ParameterdeclContext pdc : pdcl) {
            if (pdc.booldecl() != null) {
                parameters.add(new BooleanDeclaration(pdc.booldecl().VARIABLE().getSymbol().getText()));
            }
            else if (pdc.doubledecl() != null) {
                parameters.add(new DoubleDeclaration(pdc.doubledecl().VARIABLE().getSymbol().getText()));
            }
            else if (pdc.mapdecl() != null) {
                parameters.add(new MapDeclaration(pdc.mapdecl().VARIABLE().getSymbol().getText()));
            }
            else if (pdc.textdecl() != null) {
                parameters.add(new TextDeclaration(pdc.textdecl().VARIABLE().getSymbol().getText()));
            }
            else {
                System.out.println("Unknown parameter type: " + pdc.getClass().getName());
            }
        }

        for (Declaration p: parameters) {
            currentBlock.getSubBlock().addDeclaration(p);
        }

        d.setParameters(parameters);
        d.setBlock(currentBlock.getSubBlock());
        currentBlock.addDeclaration(d);

        if (d instanceof declaration.ListenerDeclaration)
            currentBlock.addStatement(new statement.ListenerDeclaration(d.getName()));
    }

    @Override
    public void enterPrint(programParser.PrintContext ctx) {
    }

    @Override
    public void exitPrint(programParser.PrintContext ctx) {
        if (ctx.expression() != null) currentBlock.addStatement(new Print(exprValues.get(ctx.expression())));
        else if (ctx.logexpression() != null) currentBlock.addStatement(new Print(logExprValues.get(ctx.logexpression())));
    }

    @Override
    public void enterCall(programParser.CallContext ctx) {
    }

    @Override
    public void exitCall(programParser.CallContext ctx) {
        Declaration d = null;
        ArrayList<Declaration> params = null;
        Call pc = null;

        if (ctx.CALL() != null) {
            if ((d = currentBlock.getVariable(ctx.VARIABLE(0).getText())) != null) {
                if (d instanceof ProcDeclaration) {
                    params = ((ProcDeclaration) d).getParameters();
                    pc = new ProcCall(d.getName());
                } else {
                    System.out.println("ERROR in CALL: " + d.getName() + " is not a procedure.");
                    return;
                }
            } else {
                System.out.println("ERROR in CALL: " + ctx.VARIABLE(0).getText() + " is not defined.");
                return;
            }
        }
        else if (ctx.THREAD() != null) {
            if ((d = currentBlock.getVariable(ctx.VARIABLE(0).getText())) != null) {
                if (d instanceof ProcDeclaration) {
                    params = ((ProcDeclaration) d).getParameters();
                    pc = new ThreadCall(d.getName());
                } else {
                    System.out.println("ERROR in CALL: " + d.getName() + " is not a procedure.");
                    return;
                }
            } else {
                System.out.println("ERROR in CALL: " + ctx.VARIABLE(0).getText() + " is not defined.");
                return;
            }
        }
        else if (ctx.EVENT() != null) {
            ArrayList<String> l = new ArrayList<String>();
            Block b = currentBlock;

            for (int i = 0; i < ctx.VARIABLE().size(); i++) {
                if ((d = b.getVariable(ctx.VARIABLE(i).getText())) != null) {
                    l.add(ctx.VARIABLE(i).getText());

                    if (d instanceof ProcDeclaration) {
                        b = ((ProcDeclaration) d).getBlock();
                    }
                    else if (d instanceof ListenerDeclaration) {
                        params = ((ListenerDeclaration) d).getParameters();
                        pc = new ListenerCall(l, b, ctx.VARIABLE(i).getText());
                    }
                }
            }

            if (pc == null) {
                System.out.println("ERROR in EVENT: no listener given in path");
                return;
            }
        }
        else return;

        List<programParser.ExpressionContext> el = ctx.expression();
        int i = 0;

        for (programParser.ExpressionContext e : el) {
            pc.addArgument(params.get(i++).getName(), exprValues.get(e));
        }

        currentBlock.addStatement(pc);
    }

    @Override
    public void enterSt_if(programParser.St_ifContext ctx) {

    }

    @Override
    public void exitSt_if(programParser.St_ifContext ctx) {
        LogicOperator cond = logExprValues.get(ctx.logexpression());
        Block thenBlock, elseBlock;

        thenBlock = nestedBlocks.get(ctx.block(0));
        if (ctx.ELSE() != null) elseBlock = nestedBlocks.get(ctx.block(1));
        else elseBlock = null;

        currentBlock.addStatement(new If(cond, thenBlock, elseBlock));
    }

    @Override
    public void enterLogexpression(programParser.LogexpressionContext ctx) {

    }

    @Override
    public void exitLogexpression(programParser.LogexpressionContext ctx) {
        LogicOperator l = logExprValues.get(ctx.condition());

        if (ctx.logexpression() != null) {
            if (ctx.AND() != null) logExprValues.put(ctx, new And(l, logExprValues.get(ctx.logexpression())));
            else if (ctx.OR() != null) logExprValues.put(ctx, new Or(l, logExprValues.get(ctx.logexpression())));

        }
        else logExprValues.put(ctx, l);
    }

    @Override
    public void enterCondition(programParser.ConditionContext ctx) {

    }

    @Override
    public void exitCondition(programParser.ConditionContext ctx) {
        if (ctx.logexpression() != null) {
            LogicOperator l = logExprValues.get(ctx.logexpression());

            if (ctx.NOT() != null) logExprValues.put(ctx, new Not(l));
            else logExprValues.put(ctx, l);
        }
        else {
            Operator left = exprValues.get(ctx.expression(0));
            Operator right = exprValues.get(ctx.expression(1));

            if (ctx.SMALLER() != null) logExprValues.put(ctx, new Smaller(left, right));
            else if (ctx.GREATER() != null) logExprValues.put(ctx, new Greater(left, right));
            else if (ctx.ASSIGNMENT() != null) logExprValues.put(ctx, new Equal(left, right));
        }
    }

    @Override
    public void enterSt_while(programParser.St_whileContext ctx) {

    }

    @Override
    public void exitSt_while(programParser.St_whileContext ctx) {
        LogicOperator cond = logExprValues.get(ctx.logexpression());
        Block loopBlock = nestedBlocks.get(ctx.block());

        currentBlock.addStatement(new While(cond, loopBlock));
    }

    @Override
    public void enterSt_return(programParser.St_returnContext ctx) {

    }

    @Override
    public void exitSt_return(programParser.St_returnContext ctx) {
        currentBlock.addStatement(new Return(exprValues.get(ctx.expression())));
    }

    @Override
    public void enterWait_for(programParser.Wait_forContext ctx) {

    }

    @Override
    public void exitWait_for(programParser.Wait_forContext ctx) {
        currentBlock.addStatement(new Wait(exprValues.get(ctx.expression())));
    }

    @Override
    public void enterReturntype(programParser.ReturntypeContext ctx) {

    }

    @Override
    public void exitReturntype(programParser.ReturntypeContext ctx) {

    }

    @Override
    public void enterAssignment(programParser.AssignmentContext ctx) {
    }

    @Override
    public void exitAssignment(programParser.AssignmentContext ctx) {
        if (ctx.expression() != null) {
            currentBlock.addStatement(new Assignment(ctx.VARIABLE().getText(),
                    exprValues.get(ctx.expression())));
        }
        else if (ctx.logexpression() != null)
            currentBlock.addStatement(new BoolAssignment(ctx.VARIABLE().getText(),
                                                      logExprValues.get(ctx.logexpression())));

    }

    @Override
    public void enterExpression(programParser.ExpressionContext ctx) {

    }

    @Override
    public void exitExpression(programParser.ExpressionContext ctx) {
        if (ctx.OPERATOR_ADD() != null) {
            exprValues.put(ctx, new Add(exprValues.get(ctx.factor()),
                                        exprValues.get(ctx.expression())));
        }
        else if (ctx.OPERATOR_SUB() != null) {
            exprValues.put(ctx, new Subtract(exprValues.get(ctx.factor()),
                    exprValues.get(ctx.expression())));
        }
        else exprValues.put(ctx, exprValues.get(ctx.factor()));
    }

    @Override
    public void enterFactor(programParser.FactorContext ctx) {

    }

    @Override
    public void exitFactor(programParser.FactorContext ctx) {
        if (ctx.NUMBER() != null) {
            exprValues.put(ctx, new Number(Double.parseDouble(ctx.NUMBER().getText())));
        }
        else if (ctx.TEXT() != null) {
            exprValues.put(ctx, new Text(ctx.TEXT().getText()));
        }
        else if (ctx.JSON() != null) {
            exprValues.put(ctx, new JSONMap(ctx.JSON().getText()));
        }
        else if (ctx.VARIABLE() != null) {
            Declaration d = currentBlock.getVariable(ctx.VARIABLE().getText());

            if (d instanceof FunctionDeclaration) {
                FunctionCall op = new FunctionCall(ctx.VARIABLE().getText());
                List<programParser.ExpressionContext> ecl = ctx.expression();
                ArrayList<Declaration> params = ((FunctionDeclaration)d).getParameters();
                int i = 0;

                for (programParser.ExpressionContext ec : ecl) {
                    op.addArgument(params.get(i++).getName(), exprValues.get(ec));
                }

                exprValues.put(ctx, op);
            }
            else exprValues.put(ctx, new Variable(ctx.VARIABLE().getText()));

        }
        else if (ctx.TRUE() != null) {
            exprValues.put(ctx, new Bool(true));
        }
        else if (ctx.FALSE() != null) {
            exprValues.put(ctx, new Bool(false));
        }
        else if (ctx.OPEN_BRACKET() != null) {
            Operator op = exprValues.get(ctx.expression());
            exprValues.put(ctx, op);
        }
        else if (ctx.OPERATOR_DIV() != null)  {
            Operator op1 = exprValues.get(ctx);
            Operator op2 = exprValues.get(ctx.factor());

            exprValues.put(ctx, new Divide(op1, op2));
        }
        else if (ctx.OPERATOR_MULT() != null) {
            Operator op1 = exprValues.get(ctx);
            Operator op2 = exprValues.get(ctx.factor());

            exprValues.put(ctx, new Mult(op1, op2));
        } else if(ctx.get() != null){
            Operator op1
        }
        else System.out.println("COMPILE Error: unknown factor: " + ctx.toString());
    }

    @Override
    public void enterGet(programParser.GetContext ctx) {
    }

    @Override
    public void exitGet(programParser.GetContext ctx) {
        exprValues.put(ctx, new GetCall(exprValues.get(ctx.expression()), ctx.TEXT().getText()));
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
