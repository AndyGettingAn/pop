package statement;

import declaration.Block;
import main.Interpreter;
import main.RuntimeScope;
import operator.Operator;

public class Wait extends Statement {
    Operator myExpr;

    public Wait(Operator e) {
        myExpr = e;
    }

    @Override
    public void execute(Block b, RuntimeScope s) {
        Object val = myExpr.evaluate(b, s);
        if (val != null) {
            if (val instanceof Double) {
                try {
                    Thread.sleep(((Double) val).intValue());
                } catch (InterruptedException e) {
                    System.out.println("RUNTIME ERROR in WAIT: " + e.getLocalizedMessage());
                }
            }
            else if (val instanceof String) {
                Thread t = Interpreter.getRuntime().getThread((String)val);
                if (t != null) {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        System.out.println("RUNTIME ERROR in WAIT: " + e.getLocalizedMessage());
                    }
                }
                else System.out.println("RUNTIME ERROR in WAIT: no thread with name " + val + " currently running.");
            }
            else System.out.println("RUNTIME ERROR in WAIT: " + myExpr + " is not of value TEXT");
        }
        else System.out.println("RUNTIME ERROR in WAIT: cannot evaluate " + myExpr.toString());
    }
}
