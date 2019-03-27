package statement;

import declaration.Block;
import main.RuntimeScope;
import operator.Operator;

public class Return extends Statement {
    private Operator myExpr;

    public Return(Operator e) {
        myExpr = e;
    }

    @Override public void execute(Block b, RuntimeScope s) {
        Object val = myExpr.evaluate(b, s);
        if (val != null) {
            System.out.println("RETURN sets value: " + val);
            s.setReturnValue(val);
            s.setExecState(RuntimeScope.ExecState.RETURN);
        } else System.out.println(s + " RUNTIME ERROR (RETURN): cannot evaluate " + myExpr.toString());
    }
}
