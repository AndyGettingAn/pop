package logic;

import declaration.Block;
import main.RuntimeScope;
import operator.Operator;

abstract public class LogicOperator {
    protected LogicOperator left, right;

    public LogicOperator() {
    }

    public LogicOperator(LogicOperator l, LogicOperator r) {
        left = l;
        right = r;
    }

    public void setLeft(LogicOperator l) {
        left = l;
    }

    public void setRight(LogicOperator r) {
        right = r;
    }

    abstract public boolean evaluate(Block myBlock, RuntimeScope myScope);
}
