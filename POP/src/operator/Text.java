package operator;

import declaration.Block;
import main.RuntimeScope;

public class Text extends Operator {
    private String value;

    public Text() {
        super();
        value = null;
    }

    public Text(String v) {
            value = v.substring(1, v.length() - 1);
    }

    public Object evaluate(Block myBlock, RuntimeScope myScope) {
            return value;
    }

    public String toString() {
        return value;
    }
}
