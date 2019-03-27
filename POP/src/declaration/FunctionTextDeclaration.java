package declaration;

import main.RuntimeScope;

public class FunctionTextDeclaration extends FunctionDeclaration {
    public FunctionTextDeclaration() {
        super();
    }

    public FunctionTextDeclaration(String varName) {
        super(varName);
    }

    public String evaluate(Block myBlock, RuntimeScope myScope) {
        Object o;
        RuntimeScope s = new RuntimeScope();
        procBlock.initVariables(s);

        procBlock.execute(s);

        o = s.getReturnValue();
        if (o instanceof String) return (String)o;
        else {
            System.out.println("RUNTIME ERROR: TEXT PROC has illegal return value ");
            return null;
        }
    }
}
