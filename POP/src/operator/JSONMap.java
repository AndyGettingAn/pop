package operator;

import datatypes.JSONData;
import declaration.Block;
import main.RuntimeScope;

public class JSONMap extends Operator {
    private JSONData value;

    public JSONMap() {
        super();
        value = null;
    }


    public JSONMap(JSONData v) {
        value = v;
    }

    public JSONMap(String v) {
        value = new JSONData(v);
    }

    public Object evaluate(Block myBlock, RuntimeScope myScope) {
        return value;
    }

    public String toString() {
        return value.toString();
    }
}