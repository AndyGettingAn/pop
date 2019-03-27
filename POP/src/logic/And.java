package logic;

import declaration.Block;
import main.RuntimeScope;

public class And extends LogicOperator {
    public And() {
        super();
    }

    public And(LogicOperator l, LogicOperator r) {
        super(l, r);
    }

    @Override
    public boolean evaluate(Block myBlock, RuntimeScope myScope) {
        boolean leftVal = left.evaluate(myBlock, myScope);
        boolean rightVal = right.evaluate(myBlock, myScope);
        return leftVal && rightVal;
    }
}
