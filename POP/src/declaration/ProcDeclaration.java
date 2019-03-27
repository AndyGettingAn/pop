package declaration;

import main.RuntimeScope;

public class ProcDeclaration extends SubcallDeclaration {
    private RuntimeScope myScope;

    public ProcDeclaration() {
        super();
    }

    public ProcDeclaration(String varName) {
        super(varName);
    }

    public void setEnv(RuntimeScope s) {
        myScope = s;
    }

    public RuntimeScope getEnv() {
        return myScope;
    }
}
