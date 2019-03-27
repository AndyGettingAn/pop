package logic;

import declaration.Block;
import main.RuntimeScope;

public class Not extends LogicOperator {
    public Not(LogicOperator o) {
        left = o;
        right = null;
    }

    @Override
    public boolean evaluate(Block myBlock, RuntimeScope myScope) {
        return !left.evaluate(myBlock, myScope);
    }
}
