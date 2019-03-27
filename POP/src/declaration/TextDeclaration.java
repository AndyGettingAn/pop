package declaration;

public class TextDeclaration  extends VarDeclaration {
    protected String value;

    public TextDeclaration() {
        super();
        value = null;
    }

    public TextDeclaration(String varName) {
        super(varName);
        value = null;
    }

    public TextDeclaration(String varName, String v) {
        super(varName);
        value = v;
    }

    public void setValue(String d) {
        value = d;
    }

    public String getValue() {
        return value;
    }

    public VarDeclaration copy() {
        if (value == null) return new TextDeclaration(name);
        else return new TextDeclaration(name, value);
    }
}