package statement;

import declaration.Block;
import main.RuntimeScope;

abstract public class Statement {
    public Statement() {}

    public abstract void execute(Block b, RuntimeScope s);
}
