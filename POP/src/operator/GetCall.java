package operator;

import datatypes.JSONData;
import declaration.Block;
import declaration.Declaration;
import declaration.DoubleDeclaration;
import declaration.FunctionDeclaration;
import main.RuntimeScope;

import java.util.HashMap;
import java.util.Map;

public class GetCall extends Operator {
    private String jsonPath;
    private Operator argument;

    public GetCall(Operator arg, String json) {
        jsonPath = json;
        argument = arg;
    }

    @Override
    public Object evaluate(Block b, RuntimeScope s) {
        Object json = argument.evaluate(b,s);

        if (json instanceof JSONData) {
            return ((JSONData) json).extractSubData(jsonPath);
        }
        else {
            System.out.println("RUNTIME ERROR: GET expects JSON object as argument.");
            return null;
        }
    }
}