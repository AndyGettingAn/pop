package statement;

import datatypes.JSONData;
import declaration.*;
import main.RuntimeScope;
import operator.Operator;

public class Assignment extends Statement {
    String myVarName;
    Operator myExpr;

    public Assignment(String varName, Operator expr) {
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
                if (d instanceof DoubleDeclaration) {
                    if (val instanceof Double) ((DoubleDeclaration)d).setValue((Double)val);
                    else System.out.println("RUNTIME ERROR: cannot assign val of type " + val.getClass().getSimpleName() + " to DOUBLE");
                }
                else if (d instanceof MapDeclaration) {
                    if (val instanceof JSONData) ((MapDeclaration)d).setValue((JSONData)val);
                    else System.out.println("RUNTIME ERROR: cannot assign val of type " + val.getClass().getSimpleName() + " to MAP");
                }
                else if (d instanceof TextDeclaration) {
                    if (val instanceof String) ((TextDeclaration)d).setValue((String)val);
                    else System.out.println("RUNTIME ERROR: cannot assign val of type " + val.getClass().getSimpleName() + " to TEXT");
                }
                else if (d instanceof BooleanDeclaration) {
                    if (val instanceof Boolean) ((BooleanDeclaration)d).setValue((Boolean)val);
                    else System.out.println("RUNTIME ERROR: cannot assign val of type " + val.getClass().getSimpleName() + " to BOOLEAN");
                }
                else {
                    System.out.println("RUNTIME ERROR in ASSIGNMENT: cannot handle variable of type " + d.getClass().getSimpleName());
                }
            }
        }
    }
}
