package main;

import declaration.Block;
import server.ServerConnector;

import java.util.ArrayList;
import java.util.HashMap;

public class Interpreter {
    private HashMap<String,ArrayList<ServerConnector>> openConnections;
    private HashMap<String,Thread> runningThreads;

    private static Interpreter me = null;

    public static Interpreter getRuntime() {
        if (me == null) me = new Interpreter();
        return me;
    }

    public Interpreter() {
        openConnections = new HashMap<String,ArrayList<ServerConnector>>();
        runningThreads = new HashMap<String, Thread>();
    }

    public void execute(Block mainBlock) {
        RuntimeScope scope = new RuntimeScope();

        mainBlock.initVariables(scope);
        mainBlock.execute(scope);
        cleanup(scope);
    }

    public void addServerConnector(RuntimeScope env, ServerConnector s) {
        ArrayList<ServerConnector> l;

        l = openConnections.get(env.toString());
        if (l == null) {
            l = new ArrayList<ServerConnector>();
            openConnections.put(env.toString(), l);
        }

        l.add(s);
        System.out.println("listener running in env " + env.toString());
        System.out.println("listener running in env " + openConnections.get(env.toString()));
    }

    public void addThread(String name, Thread t) {
        runningThreads.put(name, t);
    }

    public Thread getThread(String name) {
        return runningThreads.get(name);
    }

    public void cleanup(RuntimeScope env) {
        ArrayList<ServerConnector> l = openConnections.get(env.toString());

        if (l != null) {
            System.out.println("cleanup " + l.size() + " servers in " + env.toString());
            for (ServerConnector s : l) {
                s.setStopped(true);
                s.shutdown();
            }
        }
        else System.out.println("no servers in " +  env.toString());
    }
}
