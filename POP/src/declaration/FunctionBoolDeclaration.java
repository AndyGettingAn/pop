package declaration;

import main.RuntimeScope;

public class FunctionBoolDeclaration extends FunctionDeclaration {
    public FunctionBoolDeclaration() {
        super();
    }

    public FunctionBoolDeclaration(String varName) {
        super(varName);
    }

    public Boolean evaluate(Block myBlock, RuntimeScope myScope) {
        Object o;
        RuntimeScope s = new RuntimeScope();
        procBlock.initVariables(s);

        procBlock.execute(s);

        o = s.getReturnValue();
        if (o instanceof Boolean) return (Boolean) o;
        else {
            System.out.println("RUNTIME ERROR: DOUBLE PROC has illegal return value ");
            return null;
        }
    }
}
