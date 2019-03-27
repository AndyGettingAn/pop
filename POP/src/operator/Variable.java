package operator;

import declaration.*;
import main.RuntimeScope;

public class Variable extends Operator {
    private String value;

    public Variable() {
        super();
        value = null;
    }

    public Variable(String v) {
        super();
        value = v;
    }

    @Override
    public Object evaluate(Block myBlock, RuntimeScope myScope) {
        Declaration d = myScope.getVariable(value);

        if (d == null) {
            System.out.println("RUNTIME ERROR in block " + myScope + ": undefined variable " + value);
            return null;
        }
        else if (d instanceof DoubleDeclaration) return ((DoubleDeclaration) d).getValue();
        else if (d instanceof MapDeclaration) return ((MapDeclaration) d).getValue();
        else if (d instanceof TextDeclaration) return ((TextDeclaration) d).getValue();
        else if (d instanceof BooleanDeclaration) return ((BooleanDeclaration) d).getValue();
        else if (d instanceof FunctionDoubleDeclaration) return ((FunctionDoubleDeclaration) d).evaluate(myBlock, myScope);
        else {
            System.out.println("RUNTIME ERROR: cannot handle variable of type " + d.getClass().getSimpleName());
            return null;
        }
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return value;
    }
}
