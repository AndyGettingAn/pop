package statement;

import declaration.Block;
import logic.LogicOperator;
import main.RuntimeScope;
import operator.Operator;

public class Print extends Statement {
    Operator myExpr;
    LogicOperator myLogExpr;

    public Print(Operator e) {
        myExpr = e;
        myLogExpr = null;
    }

    public Print(LogicOperator e) {
        myExpr = null;
        myLogExpr = e;
    }
    @Override
    public void execute(Block b, RuntimeScope s) {
        Object val;

        if (myExpr != null) val = myExpr.evaluate(b, s);
        else val = myLogExpr.evaluate(b, s);

        if (val != null) {
            System.out.println("OUTPUT: " + val.toString());
        }
        else System.out.println("RUNTIME ERROR: PRINT cannot evaluate " + myExpr.toString());
    }
}
