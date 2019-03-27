package statement;

import declaration.Block;
import declaration.Declaration;
import declaration.DoubleDeclaration;
import declaration.ProcDeclaration;
import logic.Condition;
import logic.LogicOperator;
import main.RuntimeScope;
import operator.Operator;

import java.util.HashMap;
import java.util.Map;

public class If extends Statement {
    private Block thenBlock, elseBlock;
    private LogicOperator cond;

    public If(LogicOperator c, Block l, Block r) {
        cond = c;
        thenBlock = l;
        elseBlock = r;
    }

    @Override
    public void execute(Block b, RuntimeScope s) {
        RuntimeScope bodyScope = new RuntimeScope();

        bodyScope.setSuperScope(s);

        if (cond.evaluate(b, s)) {
            thenBlock.initVariables(bodyScope);
            thenBlock.execute(bodyScope);
        }
        else {
            elseBlock.initVariables(bodyScope);
            elseBlock.execute(bodyScope);
        }

        s.setExecState(bodyScope.getExecState());
        s.setReturnValue(bodyScope.getReturnValue());
    }
}
