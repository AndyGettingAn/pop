// Generated from /Users/bdludwig/Dropbox/workspace/VL_POP/src/grammar/program.g4 by ANTLR 4.7.2
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link programParser}.
 */
public interface programListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link programParser#prule}.
	 * @param ctx the parse tree
	 */
	void enterPrule(programParser.PruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#prule}.
	 * @param ctx the parse tree
	 */
	void exitPrule(programParser.PruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(programParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(programParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(programParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(programParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#mapdecl}.
	 * @param ctx the parse tree
	 */
	void enterMapdecl(programParser.MapdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#mapdecl}.
	 * @param ctx the parse tree
	 */
	void exitMapdecl(programParser.MapdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#booldecl}.
	 * @param ctx the parse tree
	 */
	void enterBooldecl(programParser.BooldeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#booldecl}.
	 * @param ctx the parse tree
	 */
	void exitBooldecl(programParser.BooldeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#doubledecl}.
	 * @param ctx the parse tree
	 */
	void enterDoubledecl(programParser.DoubledeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#doubledecl}.
	 * @param ctx the parse tree
	 */
	void exitDoubledecl(programParser.DoubledeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#textdecl}.
	 * @param ctx the parse tree
	 */
	void enterTextdecl(programParser.TextdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#textdecl}.
	 * @param ctx the parse tree
	 */
	void exitTextdecl(programParser.TextdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#parameterdecl}.
	 * @param ctx the parse tree
	 */
	void enterParameterdecl(programParser.ParameterdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#parameterdecl}.
	 * @param ctx the parse tree
	 */
	void exitParameterdecl(programParser.ParameterdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#fundecl}.
	 * @param ctx the parse tree
	 */
	void enterFundecl(programParser.FundeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#fundecl}.
	 * @param ctx the parse tree
	 */
	void exitFundecl(programParser.FundeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(programParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(programParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(programParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(programParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#st_if}.
	 * @param ctx the parse tree
	 */
	void enterSt_if(programParser.St_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#st_if}.
	 * @param ctx the parse tree
	 */
	void exitSt_if(programParser.St_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#logexpression}.
	 * @param ctx the parse tree
	 */
	void enterLogexpression(programParser.LogexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#logexpression}.
	 * @param ctx the parse tree
	 */
	void exitLogexpression(programParser.LogexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(programParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(programParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#st_while}.
	 * @param ctx the parse tree
	 */
	void enterSt_while(programParser.St_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#st_while}.
	 * @param ctx the parse tree
	 */
	void exitSt_while(programParser.St_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#st_return}.
	 * @param ctx the parse tree
	 */
	void enterSt_return(programParser.St_returnContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#st_return}.
	 * @param ctx the parse tree
	 */
	void exitSt_return(programParser.St_returnContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#wait_for}.
	 * @param ctx the parse tree
	 */
	void enterWait_for(programParser.Wait_forContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#wait_for}.
	 * @param ctx the parse tree
	 */
	void exitWait_for(programParser.Wait_forContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#returntype}.
	 * @param ctx the parse tree
	 */
	void enterReturntype(programParser.ReturntypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#returntype}.
	 * @param ctx the parse tree
	 */
	void exitReturntype(programParser.ReturntypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(programParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(programParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(programParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(programParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(programParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(programParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link programParser#get}.
	 * @param ctx the parse tree
	 */
	void enterGet(programParser.GetContext ctx);
	/**
	 * Exit a parse tree produced by {@link programParser#get}.
	 * @param ctx the parse tree
	 */
	void exitGet(programParser.GetContext ctx);
}