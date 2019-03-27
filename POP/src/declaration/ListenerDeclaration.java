package declaration;

import main.RuntimeScope;

public class ListenerDeclaration extends SubcallDeclaration {
    private RuntimeScope env;

    public ListenerDeclaration() {
        super();
    }

    public ListenerDeclaration(String varName) {
        super(varName);
    }

    public RuntimeScope resetEnv() {
        env = new RuntimeScope();
        return env;
    }

    public RuntimeScope getEnv() {
        return env;
    }
}
