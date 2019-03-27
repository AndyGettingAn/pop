package statement;

import declaration.Block;
import main.RuntimeScope;
import operator.Operator;

import java.util.HashMap;

abstract public class Call extends Statement {
    protected String name;
    protected HashMap<String, Operator> arguments;

    public Call(String n) {
        name = n;
        arguments = new HashMap<String,Operator>();
    }

    public void addArgument(String varName, Operator a) {
        arguments.put(varName, a);
    }

    abstract public void execute(Block b, RuntimeScope s);
}
