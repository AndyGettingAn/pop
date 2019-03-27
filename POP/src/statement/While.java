package statement;

import declaration.Block;
import logic.LogicOperator;
import main.RuntimeScope;

public class While extends Statement {
    private Block body;
    private LogicOperator cond;

    public While(LogicOperator c, Block b) {
        cond = c;
        body = b;
    }

    @Override
    public void execute(Block b, RuntimeScope s) {
        RuntimeScope bodyScope = new RuntimeScope();

        while (cond.evaluate(b, s) && (s.getExecState() == RuntimeScope.ExecState.RUNNING)) {
            bodyScope.setSuperScope(s);
            body.initVariables(bodyScope);
            body.execute(bodyScope);
            s.setReturnValue(bodyScope.getReturnValue());
            s.setExecState(bodyScope.getExecState());
        }
    }
}
