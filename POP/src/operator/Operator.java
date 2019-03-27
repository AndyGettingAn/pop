package operator;

import declaration.Block;
import main.RuntimeScope;

abstract public class Operator {
    protected Operator left, right;

    public Operator() {
        left = right = null;
    }

    public Operator(Operator l, Operator r) {
        left = l;
        right = r;
    }

    public void setLeft(Operator l) {
        left = l;
    }

    public void setRight(Operator r) {
        right = r;
    }

    abstract public Object evaluate(Block myBlock, RuntimeScope myScope);
}
