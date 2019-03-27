package declaration;

public class BooleanDeclaration extends VarDeclaration {
    protected Boolean value;

    public BooleanDeclaration() {
        super();
        value = null;
    }

    public BooleanDeclaration(String varName) {
        super(varName);
        value = null;
    }

    public BooleanDeclaration(String varName, boolean v) {
        super(varName);
        value = new Boolean(v);
    }

    public void setValue(Boolean d) {
        value = d;
    }

    public Boolean getValue() {
        return value;
    }

    public VarDeclaration copy() {
        if (value == null) return new BooleanDeclaration(name);
        else return new BooleanDeclaration(name, value);
    }
}