package client;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class ClientConnector {
	private Socket clientSocket;
	private DataOutputStream toServer;
	private BufferedReader fromServer;
    private int port;

	public ClientConnector(int p) {
		clientSocket = null;
		toServer = null;
		fromServer = null;
        port = p;
	}

	public boolean connected() {
		return (clientSocket != null);
	}
	
	public void init() {
		try {
			// set up

			clientSocket = new Socket("localhost", port);
			toServer = new DataOutputStream(clientSocket.getOutputStream());
			fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			System.out.println("exception during setup: " + e.getMessage());
			if (e instanceof ConnectException) {
				fromServer = null;
				toServer = null;
				clientSocket = null;
				
				System.out.println("No Server available.");
			}
			else e.printStackTrace();
		}
	}
	
	public void close() {
		if (clientSocket == null) return; 
		else {
			try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getMessage() {
		try {
			return fromServer.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	public void sendMessage(String input) {
		if (clientSocket == null) return;
		else {
			try {
				toServer.writeBytes(input + "\n");
				toServer.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
