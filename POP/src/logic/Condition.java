package logic;

import declaration.Block;
import main.RuntimeScope;
import operator.Operator;

abstract public class Condition extends LogicOperator {
    protected Operator left, right;

    public Condition() {
        left = right = null;
    }

    public Condition(Operator l, Operator r) {
        left = l;
        right = r;
    }

    abstract public boolean evaluate(Block myBlock, RuntimeScope myScope);

    public void setLeft(Operator expr) {
        left = expr;
    }

    public void setRight(Operator expr) {
        right = expr;
    }
}
