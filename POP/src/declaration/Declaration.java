package declaration;

abstract public class Declaration {
    protected String name;

    public Declaration() {name = null;}

    public Declaration(String n) { name = n; }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }
}
