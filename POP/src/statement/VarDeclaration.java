package statement;

import declaration.Declaration;
import declaration.DoubleDeclaration;
import declaration.Block;
import main.RuntimeScope;

public class VarDeclaration extends Statement {
    private String varName;

    public VarDeclaration(String name) {
        varName = name;
    }

    @Override
    public void execute(Block b, RuntimeScope s) {
        Declaration d;

        if ((d = s.getVariable(varName)) == null)
            System.out.println("RUNTIME ERROR in VarDeclaration: undeclared variable " + varName);

        /*
        this code would initalize an undefined variable to some default value.
        else {
            if (d instanceof DoubleDeclaration) {
                if (((DoubleDeclaration)d).getValue() == null) ((DoubleDeclaration) d).setValue(new Double(0.0));
            }
        }
        */
    }
}
