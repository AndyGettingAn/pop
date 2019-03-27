package operator;

import declaration.Block;
import main.RuntimeScope;

public class Number extends Operator {
    private double value;

    public Number() {
        super();
        value = Double.NaN;
    }

    public Number(double v) {
        value = v;
    }

    public Object evaluate(Block myBlock, RuntimeScope myScope) {
        return new Double(value);
    }

    public String toString() {
        return Double.toString(value);
    }
}
