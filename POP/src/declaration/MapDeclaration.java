package declaration;

import datatypes.JSONData;

public class MapDeclaration extends VarDeclaration {
    protected JSONData value;

    public MapDeclaration() {
        super();
        value = null;
    }

    public MapDeclaration(String varName) {
        super(varName);
        value = null;
    }

    public MapDeclaration(String varName, JSONData v) {
        super(varName);
        value = v;
    }

    public void setValue(JSONData d) {
        value = d;
    }

    public JSONData getValue() {
        return value;
    }

    public VarDeclaration copy() {
        if (value == null) return new MapDeclaration(name);
        else return new MapDeclaration(name, value.copy());
    }
}