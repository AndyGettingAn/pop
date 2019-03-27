package statement;

import declaration.Block;
import declaration.Declaration;
import main.Interpreter;
import main.RuntimeScope;
import server.ServerConnector;

public class ListenerDeclaration extends Statement {
    private String varName;
    private ServerConnector listener;

    public ListenerDeclaration(String name) {
        varName = name;
        listener = null;
    }

    @Override
    public void execute(Block b, RuntimeScope s) {
        Declaration d;

        if ((d = b.getVariable(varName)) == null)
            System.out.println("RUNTIME ERROR in ListenerDeclaration: undeclared variable " + varName);
        else {
            System.out.println("ENV for " + d.getName() + ": " + ((declaration.ListenerDeclaration)d).getEnv());
            listener = new ServerConnector(b, ((declaration.ListenerDeclaration)d).getEnv());
            Interpreter.getRuntime().addServerConnector(((declaration.ListenerDeclaration)d).getEnv(), listener);
        }
    }
}
