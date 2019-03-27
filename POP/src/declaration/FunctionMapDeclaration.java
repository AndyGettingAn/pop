package declaration;

import datatypes.JSONData;
import main.RuntimeScope;

public class FunctionMapDeclaration extends FunctionDeclaration {
    public FunctionMapDeclaration() {
        super();
    }

    public FunctionMapDeclaration(String varName) {
        super(varName);
    }

    public JSONData evaluate(Block myBlock, RuntimeScope myScope) {
        Object o;
        RuntimeScope s = new RuntimeScope();
        procBlock.initVariables(s);

        procBlock.execute(s);

        o = s.getReturnValue();
        if (o instanceof JSONData) return (JSONData)o;
        else {
            System.out.println("RUNTIME ERROR: MAP PROC has illegal return value ");
            return null;
        }
    }
}
