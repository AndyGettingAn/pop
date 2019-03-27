package main;
import datatypes.JSONData;
import declaration.*;
import declaration.ListenerDeclaration;
import logic.*;
import operator.*;
import operator.Number;
import statement.*;
import statement.VarDeclaration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Compiler {
    private Tokenizer scanner;
    private Tokenizer.ScanToken currentToken;

    public Compiler(InputStream code) {
        scanner = new Tokenizer(code);
    }

    private boolean functionDeclaration(Block myBlock, Tokenizer.ScanToken type) {
        SubcallDeclaration d;
        ArrayList<Declaration> parameters;
        Block b;

        if (type == Tokenizer.ScanToken.FUNCTIONDECL) {
            currentToken = scanner.scan();

            if (currentToken == Tokenizer.ScanToken.DOUBLEDECL) d = new FunctionDoubleDeclaration();
            else if (currentToken == Tokenizer.ScanToken.TEXTDECL) d = new FunctionTextDeclaration();
            else {
                System.out.println("ERROR: data type expected in PROC declaration instead of " + currentToken);
                return false;
            }
        }
        else if (type == Tokenizer.ScanToken.PROCDECL) {
            d = new ProcDeclaration();
        }
        else if (type == Tokenizer.ScanToken.LISTENERDECL) {
            d = new declaration.ListenerDeclaration();
        }
        else {
            System.out.println("ERROR: " + type + " cannot declare anything.");
            return false;
        }

        currentToken = scanner.scan();
        if (currentToken == Tokenizer.ScanToken.VARIABLE) {
            d.setName(scanner.getCurrentValue());
        }
        else {
            System.out.println("ERROR: illegal token type in PROC declaration. VARIABLE expected instead of " + currentToken);
            return false;
        }

        currentToken = scanner.scan();
        if (currentToken != Tokenizer.ScanToken.OPEN_BRACKET) {
            System.out.println("ERROR: in PROC declaration parameter declaration is missing.");
            return false;
        }
        else parameters = new ArrayList<Declaration>();

        currentToken = scanner.scan();

        while (currentToken != Tokenizer.ScanToken.CLOSE_BRACKET) {
            switch (currentToken) {
                case DOUBLEDECL:
                    currentToken = scanner.scan();
                    parameters.add(new DoubleDeclaration(scanner.getCurrentValue()));
                    currentToken = scanner.scan();
                    break;

                case TEXTDECL:
                    currentToken = scanner.scan();
                    parameters.add(new TextDeclaration(scanner.getCurrentValue()));
                    currentToken = scanner.scan();
                    break;

                case MAPDECL:
                    currentToken = scanner.scan();
                    parameters.add(new MapDeclaration(scanner.getCurrentValue()));
                    currentToken = scanner.scan();
                    break;

                case BOOLDECL:
                    currentToken = scanner.scan();
                    parameters.add(new BooleanDeclaration(scanner.getCurrentValue()));
                    currentToken = scanner.scan();
                    break;

                default:
                    System.out.println("ERROR: in PROC declaration " + currentToken + " is not a valid parameter type.");
                    return false;
            }

            if (currentToken == Tokenizer.ScanToken.COMMA) {
                currentToken = scanner.scan();
                if (currentToken == Tokenizer.ScanToken.CLOSE_BRACKET) {
                    System.out.println("ERROR: in PROC declaration another parameter expected.");
                    return false;
                }
            }
        }

        currentToken = scanner.scan();

        b = new Block();
        for (Declaration p: parameters) {
            b.addDeclaration(p);
        }

        d.setParameters(parameters);
        d.setBlock(b);
        b.setSuperBlock(myBlock);
        myBlock.addDeclaration(d);

        if (d instanceof declaration.ListenerDeclaration) myBlock.addStatement(new statement.ListenerDeclaration(d.getName()));

        if (block(b)) {
            currentToken = scanner.scan();
            return true;
        }
        else {
            System.out.println("Errors in source file. Illegal function declaration.");
            return false;
        }
    }

    private boolean mapDeclaration(Block myBlock) {
        currentToken = scanner.scan();

        if (currentToken == Tokenizer.ScanToken.VARIABLE) {
            myBlock.addDeclaration(new MapDeclaration(scanner.getCurrentValue()));
            myBlock.addStatement(new VarDeclaration(scanner.getCurrentValue()));
            currentToken = scanner.scan();

            return true;
        }
        else {
            System.out.println("ERROR: illegal token type in MAP declaration. VARIABLE expected instead of " + currentToken);
            return false;
        }
    }

    private boolean boolDeclaration(Block myBlock) {
        currentToken = scanner.scan();

        if (currentToken == Tokenizer.ScanToken.VARIABLE) {
            myBlock.addDeclaration(new BooleanDeclaration(scanner.getCurrentValue()));
            myBlock.addStatement(new VarDeclaration(scanner.getCurrentValue()));
            currentToken = scanner.scan();

            return true;
        }
        else {
            System.out.println("ERROR: illegal token type in BOOLEAN declaration. VARIABLE expected instead of " + currentToken);
            return false;
        }
    }

    private boolean textDeclaration(Block myBlock) {
        currentToken = scanner.scan();

        if (currentToken == Tokenizer.ScanToken.VARIABLE) {
            myBlock.addDeclaration(new TextDeclaration(scanner.getCurrentValue()));
            myBlock.addStatement(new VarDeclaration(scanner.getCurrentValue()));
            currentToken = scanner.scan();

            return true;
        }
        else {
            System.out.println("ERROR: illegal token type in TEXT declaration. VARIABLE expected instead of " + currentToken);
            return false;
        }
    }

    private boolean doubleDeclaration(Block myBlock) {
        currentToken = scanner.scan();

        if (currentToken == Tokenizer.ScanToken.VARIABLE) {
            myBlock.addDeclaration(new DoubleDeclaration(scanner.getCurrentValue()));
            myBlock.addStatement(new VarDeclaration(scanner.getCurrentValue()));
            currentToken = scanner.scan();

            return true;
        }
        else {
            System.out.println("ERROR: illegal token type in DOUBLE declaration. VARIABLE expected instead of " + currentToken);
            return false;
        }
    }


    private boolean print(Block myBlock) {
        Operator expr = expression(myBlock);

        if (expr != null) {
            myBlock.addStatement(new Print(expr));

            return true;
        } else {
            System.out.println("ERROR: illegal expression in PRINT.");
            return false;
        }
    }

    private boolean await(Block myBlock) {
        Operator expr = expression(myBlock);

        if (expr != null) {
            myBlock.addStatement(new Wait(expr));

            return true;
        } else {
            System.out.println("ERROR: illegal expression in WAIT.");
            return false;
        }
    }
    private boolean wait(Block myBlock) {
        Operator expr = expression(myBlock);

        if (expr != null) {
            myBlock.addStatement(new Wait(expr));

            return true;
        } else {
            System.out.println("ERROR: illegal expression in WAIT.");
            return false;
        }
    }

    private boolean call(Block myBlock, boolean threaded) {
        currentToken = scanner.scan();
        if (currentToken == Tokenizer.ScanToken.VARIABLE) {
            Declaration d;
            if ((d = myBlock.getVariable(scanner.getCurrentValue())) == null) {
                System.out.println("ERROR: undeclared PROC: " + scanner.getCurrentValue());
                return false;
            } else if (d instanceof ProcDeclaration) {
                Operator argument;
                ArrayList<Declaration> params = ((ProcDeclaration) d).getParameters();
                int i = 0;
                Call pc = threaded ? new ThreadCall(scanner.getCurrentValue()) :
                        new ProcCall(scanner.getCurrentValue());

                currentToken = scanner.scan();
                if (currentToken == Tokenizer.ScanToken.OPEN_BRACKET) {
                    if (!scanner.test(Tokenizer.ScanToken.CLOSE_BRACKET)) {
                        while (currentToken != Tokenizer.ScanToken.CLOSE_BRACKET) {
                            argument = expression(myBlock);

                            if (i < params.size()) pc.addArgument(params.get(i++).getName(), argument);
                            else {
                                System.out.println("ERROR: too many arguments given to " + d.getName());
                                return false;
                            }
                            if (currentToken == Tokenizer.ScanToken.COMMA) currentToken = scanner.scan();
                        }
                    }
                    else scanner.resetLastToken();

                    currentToken = scanner.scan();
                }

                myBlock.addStatement(pc);
                return true;
            } else {
                System.out.println("ERROR: illegal expression in CALL.");
                return false;
            }
        }
        else {
            System.out.println("ERROR: PROC name missing in CALL.");
            return false;
        }
    }


    private boolean event(Block myBlock) {
        ArrayList<String> l = new ArrayList<String>();
        Block b = myBlock;

        currentToken = scanner.scan();
        while (currentToken == Tokenizer.ScanToken.VARIABLE) {
            Declaration d;
            if ((d = b.getVariable(scanner.getCurrentValue())) == null) {
                System.out.println("ERROR: undeclared PROC: " + scanner.getCurrentValue());
                return false;
            } else if (d instanceof declaration.ListenerDeclaration) {
                Operator argument;
                ArrayList<Declaration> params = ((declaration.ListenerDeclaration) d).getParameters();
                int i = 0;
                Call pc;

                l.add(scanner.getCurrentValue());
                pc = new ListenerCall(l, b, scanner.getCurrentValue());

                currentToken = scanner.scan();
                if (currentToken == Tokenizer.ScanToken.OPEN_BRACKET) {
                    do {
                        argument = expression(myBlock);
                        pc.addArgument(params.get(i++).getName(), argument);
                    }
                    while (currentToken == Tokenizer.ScanToken.COMMA);

                    if (currentToken != Tokenizer.ScanToken.CLOSE_BRACKET) {
                        System.out.println("ERROR: proc call does not end with ')'.");
                        return false;
                    }
                    else currentToken = scanner.scan();
                }

                myBlock.addStatement(pc);
                return true;
            } else if (d instanceof ProcDeclaration) {
                l.add(scanner.getCurrentValue());
                b = ((ProcDeclaration) d).getBlock();
                currentToken = scanner.scan();
                if (currentToken == Tokenizer.ScanToken.COMMA) currentToken = scanner.scan();
            }
            else {
                System.out.println("ERROR: illegal expression in CALL.");
                return false;
            }
        }

        // while loop terminated without having found a ListenerDeclaration in the argument of EVENT
        // this is an error.

        System.out.println("ERROR in EVENT: no listener given.");
        return false;
    }

    private boolean retStatement(Block myBlock) {
        Operator expr = expression(myBlock);

        if (expr != null) {
            myBlock.addStatement(new Return(expr));

            return true;
        } else {
            System.out.println("ERROR: illegal expression in return.");
            return false;
        }
    }

    private LogicOperator condition(Block myBlock) {
        Operator left, right;
        Condition cond;

        left = expression(myBlock);

        if((left == null) && (currentToken == Tokenizer.ScanToken.NOT)) {
            currentToken = scanner.scan();

            if (currentToken == Tokenizer.ScanToken.OPEN_BRACKET) {
                LogicOperator l = logic_expression(myBlock);

                if (currentToken == Tokenizer.ScanToken.CLOSE_BRACKET) {
                    currentToken = scanner.scan();
                    return new Not(l);
                }
                else {
                    System.out.println("ERROR: illegal token in logical expression: " + currentToken + " (')' expected.");
                    return null;
                }
            }
            else {
                System.out.println("ERROR: illegal token in logical expression: " + currentToken + " ('(' expected.");
                return null;
            }
        }
        else if (left != null) {
            if (currentToken == Tokenizer.ScanToken.GREATER) cond = new Greater();
            else if (currentToken == Tokenizer.ScanToken.SMALLER) cond = new Smaller();
            else if (currentToken == Tokenizer.ScanToken.ASSIGNMENT) cond = new Equal();
            else {
                System.out.println("ERROR: illegal symbol in condition: " + currentToken + " (<, >, or = expected.");
                return null;
            }

            right = expression(myBlock);
            if (right != null) {
                cond.setLeft(left);
                cond.setRight(right);
                return cond;
            } else {
                System.out.println("ERROR: illegal right expression in condition.");
                return null;
            }
        } else {
            System.out.println("ERROR: illegal left expression in condition.");
            return null;
        }
    }

    private boolean while_statement(Block myBlock) {
        LogicOperator cond = logic_expression(myBlock);

        Block loopBlock = new Block();
        loopBlock.setSuperBlock(myBlock);

        if (block(loopBlock)) {
            currentToken = scanner.scan();
            myBlock.addStatement(new While(cond, loopBlock));
            return true;
        }
        else {
            System.out.println("ERROR: wrong THEN block in WHILE");
            return false;
        }


    }

    private boolean if_statement(Block myBlock) {
        LogicOperator cond = logic_expression(myBlock);
        Block thenBlock = new Block(), elseBlock = null;

        thenBlock.setSuperBlock(myBlock);
        if (block(thenBlock)) {
            currentToken = scanner.scan();

            if (currentToken == Tokenizer.ScanToken.ELSE) {
                currentToken = scanner.scan();
                elseBlock = new Block();
                elseBlock.setSuperBlock(myBlock);

                if (block(elseBlock)) currentToken = scanner.scan();
                else {
                    System.out.println("ERROR: wrong ELSE block in IF");
                    return false;
                }
            }
        }
        else {
            System.out.println("ERROR: wrong THEN block in IF");
            return false;
        }

        myBlock.addStatement(new If(cond, thenBlock, elseBlock));
        return true;
    }

    private boolean statement(Block myBlock) {
        boolean success = false;

        if (currentToken == Tokenizer.ScanToken.VARIABLE) success = assignment(myBlock);
        else if (currentToken == Tokenizer.ScanToken.MAPDECL) success = mapDeclaration(myBlock);
        else if (currentToken == Tokenizer.ScanToken.BOOLDECL) success = boolDeclaration(myBlock);
        else if (currentToken == Tokenizer.ScanToken.DOUBLEDECL) success = doubleDeclaration(myBlock);
        else if (currentToken == Tokenizer.ScanToken.TEXTDECL) success = textDeclaration(myBlock);
        else if (currentToken == Tokenizer.ScanToken.LISTENERDECL) success = functionDeclaration(myBlock, currentToken);
        else if (currentToken == Tokenizer.ScanToken.FUNCTIONDECL) success = functionDeclaration(myBlock, currentToken);
        else if (currentToken == Tokenizer.ScanToken.PROCDECL) success = functionDeclaration(myBlock, currentToken);
        else if (currentToken == Tokenizer.ScanToken.PRINT) success = print(myBlock);
        else if (currentToken == Tokenizer.ScanToken.WAIT) success = wait(myBlock);
        else if (currentToken == Tokenizer.ScanToken.AWAIT) success = await(myBlock);
        else if (currentToken == Tokenizer.ScanToken.EVENT) success = event(myBlock);
        else if (currentToken == Tokenizer.ScanToken.CALL) success = call(myBlock, false);
        else if (currentToken == Tokenizer.ScanToken.THREAD) success = call(myBlock, true);
        else if (currentToken == Tokenizer.ScanToken.IF) success = if_statement(myBlock);
        else if (currentToken == Tokenizer.ScanToken.WHILE) success = while_statement(myBlock);
        else if (currentToken == Tokenizer.ScanToken.RETURN) success = retStatement(myBlock);
        else System.out.println("ERROR: statement must not start with " + currentToken);

        if (success == true) {
            if (currentToken != Tokenizer.ScanToken.EOS) {
                System.out.println("ERROR: statement must end with ';' instead of " + currentToken);
                return false;
            }
            else {
                currentToken = scanner.scan();
                return true;
            }
        }
        else return false;
    }

    private boolean assignment(Block myBlock) {
        String varName = scanner.getCurrentValue();

        currentToken = scanner.scan();
        if (currentToken == Tokenizer.ScanToken.ASSIGNMENT) {
            Operator expr = expression(myBlock);

            if (expr != null) {
                myBlock.addStatement(new Assignment(varName, expr));
            } else {
                System.out.println("ERROR: illegal expression in assignment.");
                return false;
            }
        }
        else if (currentToken == Tokenizer.ScanToken.BOOL_ASSIGNMENT) {
            LogicOperator expr = logic_expression(myBlock);

            if (expr != null) {
                myBlock.addStatement(new BoolAssignment(varName, expr));
            } else {
                System.out.println("ERROR: illegal expression in assignment.");
                return false;
            }
        }
        else {
            System.out.println("ERROR: assignment operator is missing: " + scanner.getCurrentValue());
            return false;
        }

        return true;
    }

    private Operator factor(Block myBlock) {
        Operator o1 = null;

        currentToken = scanner.scan();
        if (currentToken == Tokenizer.ScanToken.NUMBER) o1 = new Number(scanner.getCurrentNumber());
        else if (currentToken == Tokenizer.ScanToken.STRING) o1 = new Text(scanner.getCurrentValue());
        else if (currentToken == Tokenizer.ScanToken.TRUE) o1 = new Bool(true);
        else if (currentToken == Tokenizer.ScanToken.FALSE) o1 = new Bool(false);
        else if (currentToken == Tokenizer.ScanToken.JSON) o1 = new JSONMap(scanner.getCurrentValue());
        else if (currentToken == Tokenizer.ScanToken.GET) {
            currentToken = scanner.scan();
            if (currentToken == Tokenizer.ScanToken.OPEN_BRACKET) {
                Operator argument;

                argument = expression(myBlock);

                if (currentToken == Tokenizer.ScanToken.COMMA) currentToken = scanner.scan();
                else {
                    System.out.println("ERROR: arguments in get must be separated by comma.");
                    return null;
                }

                if (currentToken == Tokenizer.ScanToken.STRING) {
                    o1 = new GetCall(argument, scanner.getCurrentValue());
                    currentToken = scanner.scan();
                }
                else {
                    System.out.println("ERROR: get expects STRING for JSON path.");
                    return null;
                }
            }
            else {
                System.out.println("ERROR: '(' missing after 'get'");
                return null;
            }

            if (currentToken != Tokenizer.ScanToken.CLOSE_BRACKET) {
                System.out.println("ERROR: 'get' must end with ')'.");
                return null;
            }
        }
        else if (currentToken == Tokenizer.ScanToken.VARIABLE) {
            Declaration d;
            if ((d = myBlock.getVariable(scanner.getCurrentValue())) == null) {
                System.out.println("ERROR: undeclared variable: " + scanner.getCurrentValue());
                return null;
            }
            else {
                if (d instanceof FunctionDeclaration) {
                    Operator argument;
                    ArrayList<Declaration> params = ((FunctionDeclaration)d).getParameters();
                    int i = 0;

                    o1 = new FunctionCall(scanner.getCurrentValue());

                    currentToken = scanner.scan();
                    if (currentToken == Tokenizer.ScanToken.OPEN_BRACKET) {
                        while (currentToken != Tokenizer.ScanToken.CLOSE_BRACKET) {
                            argument = expression(myBlock);
                            ((FunctionCall) o1).addArgument(params.get(i++).getName(), argument);
                            if (currentToken == Tokenizer.ScanToken.COMMA) currentToken = scanner.scan();
                        }

                        if (currentToken != Tokenizer.ScanToken.CLOSE_BRACKET) {
                            System.out.println("ERROR: function call does not end with ')'.");
                            return null;
                        }
                    }
                }
                else o1 = new Variable(scanner.getCurrentValue());
            }
        }
        else if (currentToken == Tokenizer.ScanToken.OPEN_BRACKET) {
            o1 = expression(myBlock);

            if (currentToken != Tokenizer.ScanToken.CLOSE_BRACKET) {
                System.out.println("ERROR: brackets not balanced.");
                return null;
            }
        }
        else if (currentToken == Tokenizer.ScanToken.NOT) {
            // LL(1) for negated conditions
            // NOT is optional if the condition is negated :-)
            // so read NOT is not an error if factor() is called from condition()
            // otherwise it is. However, currently factor() does not know
            // which rule has called it. This is to be corrected (better use ANTLR
            // for a correct handling of look ahead for optional symbols on the right hand
            // side of a rule.
            return null;
        } else if ((currentToken == Tokenizer.ScanToken.OPERATOR) &&
                (scanner.getCurrentOperator() instanceof Subtract)) {
            Operator o2 = expression(myBlock);
            if (o2 != null) {
                o1 = new Mult();
                o1.setLeft(new Number(-1.0));
                o1.setRight(o2);
            }
            else {
                System.out.println("ERROR in factor: illegal syntax");
                return null;
            }
        } else {
            System.out.println("ERROR: illegal token type in factor: " + currentToken);
            return null;
        }

        currentToken = scanner.scan();

        if (currentToken == Tokenizer.ScanToken.OPERATOR) {
            Operator op = scanner.getCurrentOperator();

            if ((op instanceof Mult) || (op instanceof Divide)) {
                Operator o2 = factor(myBlock);

                op.setLeft(o1);
                op.setRight(o2);

                return op;
            }
            else return o1;
        }
        else return o1;
    }

    public Operator expression(Block myBlock) {
        Operator o1;

        o1 = factor(myBlock);

        if (currentToken == Tokenizer.ScanToken.OPERATOR) {
            Operator op = scanner.getCurrentOperator();

            if ((op instanceof Add) || (op instanceof Subtract)) {
                Operator o2 = expression(myBlock);

                op.setLeft(o1);
                op.setRight(o2);

                return op;
            }
            else return o1;
        }
        else return o1;
    }

    public LogicOperator logic_expression(Block myBlock) {
        LogicOperator c1, c2, o;

        c1 = condition(myBlock);
        if (c1 != null) {
            if (currentToken == Tokenizer.ScanToken.AND) o = new And();
            else if (currentToken == Tokenizer.ScanToken.OR) o = new Or();
            else return c1;

            c2 = logic_expression(myBlock);
            if (c2 != null) {
                o.setLeft(c1);
                o.setRight(c2);

                return o;
            } else {
                System.out.println("ERROR: syntax error in condition");
                return null;
            }
        } else {
            System.out.println("ERROR: syntax error in condition");
            return null;
        }
    }

    public Block program() {
        Block mainBlock = new Block();

        currentToken = scanner.scan();
        if (currentToken == Tokenizer.ScanToken.PROGRAM) {
            currentToken = scanner.scan();

            if (currentToken == Tokenizer.ScanToken.VARIABLE) {
                System.out.println("PROGRAM " + scanner.getCurrentValue());
                currentToken = scanner.scan();

                if (block(mainBlock)) return mainBlock;
                else return null;
            }
            else System.out.println("ERROR: wrong token in program header: " + currentToken);
        }
        else System.out.println("ERROR: PROGRAM missing.");

        return null;
    }

    private boolean block(Block b) {
        if (currentToken == Tokenizer.ScanToken.OPEN_BLOCK) {
            currentToken = scanner.scan();

            while ((currentToken != Tokenizer.ScanToken.CLOSE_BLOCK) &&
                    (currentToken != Tokenizer.ScanToken.EOF)) {
                if (!statement(b)) return false;
            }

            if (currentToken == Tokenizer.ScanToken.EOF) {
                System.out.println("ERROR: file ends before block is closed.");
                return false;
            }
        }
        else {
            System.out.println("ERROR: block does not start with ‘{‘.");
            return false;
        }

        return true;
    }
}
