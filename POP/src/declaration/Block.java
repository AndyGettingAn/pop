package declaration;

import main.RuntimeScope;
import main.Tokenizer;
import statement.Return;
import statement.Statement;

import java.util.*;

public class Block {
    private ArrayList<Statement> statements;
    private HashMap<String, Declaration> declaredVariables;
    private Block superBlock;
    private Block subBlock;

    public Block() {
        statements = new ArrayList<Statement>();
        declaredVariables = new HashMap<String, Declaration>();
        superBlock = null;
        subBlock = null;
    }

    public Block(Block b) {
        statements = new ArrayList<Statement>();
        declaredVariables = new HashMap<String, Declaration>();
        superBlock = b;
        subBlock = null;
    }

    public void setSubBlock(Block b) {
        subBlock = b;
    }

    public void setSuperBlock(Block b) {
        superBlock = b;
    }

    public Block getSubBlock() {
        return subBlock;
    }

    public Block getSuperBlock() {
        return superBlock;
    }

    public void addStatement(Statement s) {
        statements.add(s);
    }

    public void execute(RuntimeScope myScope) {
        ListIterator<Statement> statsInBlock = statements.listIterator();
        Statement s;

        while (statsInBlock.hasNext() && myScope.getExecState() == RuntimeScope.ExecState.RUNNING) {
            s = statsInBlock.next();
            s.execute(this, myScope);
        }
    }

    public void addDeclaration (Declaration decl) {
        declaredVariables.put(decl.getName(), decl);
    }

    public void initVariables(RuntimeScope scope) {
        Collection<Declaration> entries = declaredVariables.values();
        for (Declaration e : entries) {
            if (e instanceof VarDeclaration) {
                scope.addDeclaration(((VarDeclaration)e).copy());
            }
        }
    }

    public Declaration getVariable(String name) {
        Declaration d = declaredVariables.get(name);

        if (d != null) return d;
        else if (superBlock != null) {
            return superBlock.getVariable(name);
        }
        else {
            return null;
        }
    }
}
