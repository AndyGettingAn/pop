package main;

import declaration.Block;
import declaration.Declaration;
import server.ServerConnector;
import statement.Statement;

import java.util.ArrayList;
import java.util.HashMap;

public class RuntimeScope {
    public enum ExecState { RUNNING, RETURN, BREAK, CONTINUE, WHILE, IF};

    private RuntimeScope superScope;
    private Object returnValue;
    private HashMap<String, Declaration> declaredVariables;
    private ExecState myState;

    public RuntimeScope() {
        declaredVariables = new HashMap<String, Declaration>();
        myState = ExecState.RUNNING;
        superScope = null;
    }

    public void setExecState(ExecState e) {
        myState = e;
    }

    public ExecState getExecState() {
        return myState;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Object o) {
        returnValue = o;
    }

    public void setSuperScope(RuntimeScope b) {
        superScope = b;
    }

    public RuntimeScope getSuperScope() {
        return superScope;
    }

    public void addDeclaration (Declaration decl) {
        declaredVariables.put(decl.getName(), decl);
    }

    public Declaration getVariable(String name) {
        Declaration d = declaredVariables.get(name);

        if (d != null) return d;
        else if (superScope != null) {
            return superScope.getVariable(name);
        }
        else {
            return null;
        }
    }
}
