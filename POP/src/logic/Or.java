package logic;

import declaration.Block;
import main.RuntimeScope;

public class Or extends LogicOperator {
    public Or() {
        super();
    }

    public Or(LogicOperator l, LogicOperator r) {
        super(l, r);
    }

    @Override
    public boolean evaluate(Block myBlock, RuntimeScope myScope) {
        return left.evaluate(myBlock, myScope) || right.evaluate(myBlock, myScope);
    }
}
