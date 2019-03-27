package statement;

import client.ClientConnector;
import datatypes.JSONData;
import declaration.*;
import main.RuntimeScope;
import operator.Operator;
import declaration.ListenerDeclaration;

import java.util.ArrayList;
import java.util.Map;

public class ListenerCall extends Call {
    private ClientConnector event;
    private ArrayList<String> listenerPath;
    private Block listenerBlock;

    public ListenerCall(ArrayList<String> l, Block b, String n) {
        super(n);
        listenerPath = l;
        listenerBlock = b;
    }

    @Override
    public void execute(Block b, RuntimeScope s) {
        RuntimeScope superEnv;
        Declaration d = listenerBlock.getVariable(name);
        Declaration d1;

        System.out.println(this.getClass().getName() + ".execute: " + name);
        if (listenerPath.size() > 1) {
            d1 = listenerBlock.getVariable(listenerPath.get(listenerPath.size()-2));
            if (d1 instanceof ProcDeclaration) {
                if (((ProcDeclaration)d1).getEnv() != null) return;
                superEnv = ((ProcDeclaration)d1).getEnv();
            }
            else superEnv = s;
        }
        else superEnv = s;

        if (d instanceof declaration.ListenerDeclaration) {
            Block procBlock = ((declaration.ListenerDeclaration)d).getBlock();
            RuntimeScope bodyScope = ((declaration.ListenerDeclaration)d).resetEnv();

            bodyScope.setSuperScope(superEnv);
            procBlock.initVariables(bodyScope);
            System.out.println("proc block: " + procBlock.toString());
            System.out.println("listener block: " + listenerBlock.toString());
            System.out.println("scope: " + bodyScope.toString() + " super: " + bodyScope.getSuperScope().toString());

            for (Map.Entry<String,Operator> argument : arguments.entrySet()) {
                Declaration param = bodyScope.getVariable(argument.getKey());

                if (param == null) System.out.println("RUNTIME ERROR: argument does not match a parameter: " + argument.getKey());
                else if (param instanceof DoubleDeclaration) ((DoubleDeclaration)param).setValue((Double)argument.getValue().evaluate(b, s));
                else if (param instanceof TextDeclaration) ((TextDeclaration)param).setValue((String)argument.getValue().evaluate(b, s));
                else if (param instanceof BooleanDeclaration) ((BooleanDeclaration)param).setValue((Boolean)argument.getValue().evaluate(b, s));
                else if (param instanceof MapDeclaration) ((MapDeclaration)param).setValue((JSONData)argument.getValue().evaluate(b, s));
                else System.out.println("RUNTIME ERROR in PROCEDURE CALL: illegal parameter type: " + param.getClass().getSimpleName());
            }

            event = new ClientConnector(6789);
            event.init();
            event.sendMessage(name);
            event.close();
        } else System.out.println("RUNTIME ERROR: " + name + " is not a defined listener");
    }
}