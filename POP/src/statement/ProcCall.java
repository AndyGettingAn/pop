package statement;

import datatypes.JSONData;
import declaration.*;
import main.RuntimeScope;
import operator.Operator;

import java.util.HashMap;
import java.util.Map;

public class ProcCall extends Call {
    public ProcCall(String n) {
        super(n);
    }

    @Override
    public void execute(Block b, RuntimeScope s) {
        Declaration d = b.getVariable(name);

        if (d instanceof ProcDeclaration) {
            RuntimeScope bodyScope = new RuntimeScope();
            Block procBlock = ((ProcDeclaration)d).getBlock();

            bodyScope.setSuperScope(s);
            procBlock.initVariables(bodyScope);

            for (Map.Entry<String,Operator> argument : arguments.entrySet()) {
                Declaration param = bodyScope.getVariable(argument.getKey());
                if (param != null) {
                    if (param instanceof DoubleDeclaration) ((DoubleDeclaration)param).setValue((Double)argument.getValue().evaluate(b, s));
                    else if (param instanceof TextDeclaration) ((TextDeclaration)param).setValue((String)argument.getValue().evaluate(b, s));
                    else if (param instanceof BooleanDeclaration) ((BooleanDeclaration)param).setValue((Boolean)argument.getValue().evaluate(b, s));
                    else if (param instanceof MapDeclaration) ((MapDeclaration)param).setValue((JSONData)argument.getValue().evaluate(b, s));
                    else System.out.println("RUNTIME ERROR in PROCEDURE CALL: illegal parameter type: " + param.getClass().getSimpleName());
                }
                else System.out.println("RUNTIME ERROR: argument does not match a parameter: " + argument.getKey());
            }

            procBlock.execute(bodyScope);
        }
        else System.out.println("RUNTIME ERROR: " + name + " is not a defined procedure");
    }
}
