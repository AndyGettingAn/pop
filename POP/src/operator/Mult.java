package operator;

import declaration.Block;
import main.RuntimeScope;

public class Mult extends Operator {
    public Mult() {
        super();
    }

    public Mult(Operator l, Operator r) {
        super(l, r);
    }

    public Object evaluate(Block myBlock, RuntimeScope myScope) {
        Object l = left.evaluate(myBlock, myScope);
        Object r = right.evaluate(myBlock, myScope);

        if (l instanceof Double && r instanceof Double) {
            return new Double(((Double)l).doubleValue() * ((Double)r).doubleValue());
        }
        else {
            System.out.println("RUNTIME ERROR in Mult: operands do have different data types.");
            return null;
        }
    }

    public String toString() {
        String res;

        if ((left != null) && (right != null)) {
            res = "(" + left.toString() + "*" + right.toString() + ")";
        }
        else res = "*";

        return res;
    }
}
