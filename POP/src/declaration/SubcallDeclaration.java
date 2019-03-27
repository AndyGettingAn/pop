package declaration;

import java.util.ArrayList;

public class SubcallDeclaration extends Declaration {
    protected Block procBlock;
    protected ArrayList<Declaration> parameters;

    public SubcallDeclaration() {
        super();
    }

    public SubcallDeclaration(String varName) {
        super(varName);
    }

    public ArrayList<Declaration> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Declaration> p) {
        parameters = p;
    }

    public void setBlock(Block b) {
        procBlock = b;
    }

    public Block getBlock() {
        return procBlock;
    }
}
