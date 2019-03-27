package logic;

import declaration.Block;
import main.RuntimeScope;
import operator.Operator;

public class Equal extends Condition {
    public Equal() {
        super();
    }

    public Equal(Operator l, Operator r) {
        super(l, r);
    }

    @Override
    public boolean evaluate(Block myBlock, RuntimeScope myScope) {
        Object op1, op2;

        op1 = left.evaluate(myBlock, myScope);
        op2 = right.evaluate(myBlock, myScope);

        if (op1 instanceof Double && op2 instanceof Double) {
            return ((Double)op1).doubleValue() == ((Double)op2).doubleValue();
        }
        if (op1 instanceof String && op2 instanceof String) {
            return ((String)op1).equals((String)op2);
        }
        else {
            System.out.println("RUNTIME ERROR: operands of EQUAL have different data types.");
            return false;
        }
    }
}
