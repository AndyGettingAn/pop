package declaration;

abstract public class VarDeclaration extends Declaration {
    public VarDeclaration() {
        super();
    }

    public VarDeclaration(String name) {
        super(name);
    }

    abstract public VarDeclaration copy();
}
