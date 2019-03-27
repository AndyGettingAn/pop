package declaration;

public class DoubleDeclaration extends VarDeclaration {
    protected Double value;

    public DoubleDeclaration() {
        super();
        value = null;
    }

    public DoubleDeclaration(String varName) {
        super(varName);
        value = null;
    }

    public DoubleDeclaration(String varName, double v) {
        super(varName);
        value = new Double(v);
    }

    public void setValue(Double d) {
        value = d;
    }

    public Double getValue() {
        return value;
    }

    public VarDeclaration copy() {
        if (value == null) return new DoubleDeclaration(name);
        else return new DoubleDeclaration(name, value);
    }
}
