package declaration;

import main.RuntimeScope;

public class FunctionDoubleDeclaration extends FunctionDeclaration {
    public FunctionDoubleDeclaration() {
        super();
    }

    public FunctionDoubleDeclaration(String varName) {
        super(varName);
    }

    public Double evaluate(Block myBlock, RuntimeScope myScope) {
        Object o;
        RuntimeScope s = new RuntimeScope();
        procBlock.initVariables(s);

        procBlock.execute(s);

        o = s.getReturnValue();
        if (o instanceof Double) return (Double)o;
        else {
            System.out.println("RUNTIME ERROR: DOUBLE PROC has illegal return value ");
            return null;
        }
    }
}
