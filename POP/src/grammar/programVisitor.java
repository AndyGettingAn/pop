// Generated from /Users/bdludwig/Dropbox/workspace/VL_POP/src/grammar/program.g4 by ANTLR 4.7.2
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link programParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface programVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link programParser#prule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrule(programParser.PruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(programParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(programParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#mapdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapdecl(programParser.MapdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#booldecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooldecl(programParser.BooldeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#doubledecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubledecl(programParser.DoubledeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#textdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextdecl(programParser.TextdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#parameterdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterdecl(programParser.ParameterdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#fundecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFundecl(programParser.FundeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(programParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(programParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#st_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSt_if(programParser.St_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#logexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogexpression(programParser.LogexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(programParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#st_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSt_while(programParser.St_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#st_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSt_return(programParser.St_returnContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#wait_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWait_for(programParser.Wait_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#returntype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturntype(programParser.ReturntypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(programParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(programParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(programParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link programParser#get}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGet(programParser.GetContext ctx);
}