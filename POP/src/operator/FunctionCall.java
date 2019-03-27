package operator;

import datatypes.JSONData;
import declaration.*;
import main.RuntimeScope;

import java.util.HashMap;
import java.util.Map;

public class FunctionCall extends Operator {
    private String varName;
    private HashMap<String,Operator> arguments;

    public FunctionCall(String name) {
        varName = name;
        arguments = new HashMap<String,Operator>();
    }

    public void addArgument(String varName, Operator a) {
        arguments.put(varName, a);
    }

    @Override
    public Object evaluate(Block b, RuntimeScope s) {
        Declaration d;

        System.out.println("EVALUATE FunctionCall: " + this);
        if ((d = b.getVariable(varName)) == null) {
            System.out.println("RUNTIME ERROR: in block " + b + " undeclared function " + varName);
            return null;
        }
        else if (d instanceof FunctionDeclaration) {
            RuntimeScope bodyScope = new RuntimeScope();
            Block procBlock = ((FunctionDeclaration)d).getBlock();

            bodyScope.setSuperScope(s);
            procBlock.initVariables(bodyScope);

            for (Map.Entry<String,Operator> argument : arguments.entrySet()) {
                Declaration param = bodyScope.getVariable(argument.getKey());
                System.out.println("FUNCTION CALL has argument: " + argument.getValue());
                if (param != null) {
                    if (param instanceof DoubleDeclaration) ((DoubleDeclaration)param).setValue((Double)argument.getValue().evaluate(b, s));
                    else if (param instanceof TextDeclaration) ((TextDeclaration)param).setValue((String)argument.getValue().evaluate(b, s));
                    else if (param instanceof BooleanDeclaration) ((BooleanDeclaration)param).setValue((Boolean)argument.getValue().evaluate(b, s));
                    else if (param instanceof MapDeclaration) ((MapDeclaration)param).setValue((JSONData)argument.getValue().evaluate(b, s));
                    else System.out.println("RUNTIME ERROR in FUNCTIONCALL: illegal parameter type: " + param.getClass().getSimpleName());
                }
                else System.out.println("RUNTIME ERROR: argument does not match a parameter: " + argument.getKey());
            }

            procBlock.execute(bodyScope);

            System.out.println("FUNCTION CALL has return value " + bodyScope.getReturnValue());
            s.setReturnValue(bodyScope.getReturnValue());

            return bodyScope.getReturnValue();
        }
        else {
            System.out.println("RUNTIME ERROR: " + varName + " is not defined as a function.");
            return null;
        }
    }
}
