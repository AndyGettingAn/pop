package statement;

import declaration.*;
import logic.LogicOperator;
import main.RuntimeScope;

public class BoolAssignment extends Statement {
    String myVarName;
    LogicOperator myExpr;

    public BoolAssignment(String varName, LogicOperator expr) {
        myVarName = varName;
        myExpr = expr;
    }

    public void execute(Block b, RuntimeScope s) {
        Object val = myExpr.evaluate(b, s);
        if (val != null) {
            Declaration d = s.getVariable(myVarName);
            if (d == null) {
                System.out.println("RUNTIME ERROR: undefined variable " + myVarName);
            }
            else {
                if (d instanceof BooleanDeclaration) {
                    if (val instanceof Boolean) ((BooleanDeclaration)d).setValue((Boolean)val);
                    else System.out.println("RUNTIME ERROR: cannot assign val of type " + val.getClass().getSimpleName() + " to BOOLEAN");
                }
                else {
                    System.out.println("RUNTIME ERROR in BOOL ASSIGNMENT: cannot handle variable of type " + d.getClass().getSimpleName());
                }
            }
        }
    }
}
