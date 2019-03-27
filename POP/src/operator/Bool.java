package operator;

import declaration.Block;
import main.RuntimeScope;

public class Bool extends Operator {
    private Bool value;

    public Bool() {
        super();
        value = null;
    }

    public Bool(boolean v) {
        value = new Bool(v);
    }

    public Object evaluate(Block myBlock, RuntimeScope myScope) {
        return value;
    }

    public String toString() {
        return value.toString();
    }
}