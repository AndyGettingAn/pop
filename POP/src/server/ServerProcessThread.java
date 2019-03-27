package server;

import datatypes.JSONData;
import declaration.*;
import main.RuntimeScope;
import operator.Operator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;

public class ServerProcessThread extends Thread {
	private ServerConnector myConn;
	private Block myCodeBlock;
	private RuntimeScope myEnv;

	public ServerProcessThread(ServerConnector conn, Block b, RuntimeScope s) {
		this.myConn = conn;
        myConn.setStopped(false);

        myCodeBlock = b;
        myEnv = s;
	}

	public void closeConnection() {
		myConn.setConnectionClosed(true);
	}
	
	public void run() {
		String data, answer = "ok";

		while (!myConn.isStopped()) {
			try {
                Socket server = myConn.getMe().accept();
				myConn.setConnectionClosed(false);
				
				while (!myConn.isConnectionClosed()) {
					//System.out.println(this + " is waiting for request");
					 myConn.setIn(new BufferedReader(new InputStreamReader(server.getInputStream())));
					 myConn.setOut(new DataOutputStream(server.getOutputStream()));
					 
					 data = myConn.getIn().readLine();
					 if (data != null) {
						 //System.out.println(this + "processes request: " + data);
						 if (data.equals("stop")) {
						 	myConn.setConnectionClosed(true);
						 	myConn.setStopped(true);
						 }
						 else {
							 Declaration d = myCodeBlock.getVariable(data);
							 if (d instanceof declaration.ListenerDeclaration) {
								 RuntimeScope bodyScope = ((declaration.ListenerDeclaration)d).getEnv();
								 Block procBlock = ((SubcallDeclaration)d).getBlock();

								 System.out.println("scope: " + bodyScope.toString());
								 System.out.println("block: " + procBlock.toString());

								 procBlock.execute(bodyScope);
							 }
						 }
					 }
					 else myConn.setConnectionClosed(true);
				}

				server.close();
            }
			catch (IOException e) {
				if (!myConn.isStopped()) {
					System.err.println("Error while communicating via TCP: " + e);
					e.printStackTrace();
				}
				else System.out.println("Terminating Server Process Thread after shutdown was requested.");
			}
		}

		myConn.shutdown();
	}
}
