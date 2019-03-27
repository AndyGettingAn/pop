package server;

import declaration.Block;
import main.RuntimeScope;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnector {
	private ServerSocket me;
	private Socket server;
	private BufferedReader in;
	private DataOutputStream out;
	private ServerProcessThread myReader;
	private boolean stopped;
	private boolean connectionClosed;
	private boolean sending;

	public ServerConnector(Block b, RuntimeScope s) {
		sending = false;

		try {
			initTCPIPServer();

            myReader = new ServerProcessThread(this, b, s);
            myReader.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Cannot establish socket: " + e.toString());
			me = null;
		}
	}

	public boolean isSending() {
		return sending;
	}
	
	public ServerSocket getMe() {
		return me;
	}

	public void setMe(ServerSocket me) {
		this.me = me;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}


	public boolean isStopped() {
		return stopped;
	}


	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}


	public boolean isConnectionClosed() {
		return connectionClosed;
	}


	public void setConnectionClosed(boolean connectionClosed) {
		this.connectionClosed = connectionClosed;
	}


	public boolean isConnected() {
		return (me != null);
	}
	
	private void shutdownTCPIPServer() throws IOException {
		me.close();
	}
	
	private synchronized void initTCPIPServer() throws IOException {
		me = new ServerSocket(6789);
	}

	public void shutdown() {
		try {
			stopped = true;
			if (!connectionClosed) {
				if (in != null) {
					in.close();
					in = null;
				}
				if (out != null) {
					out.close();
					out = null;
				}
				if (server != null) {
					server.close();
					server = null;
				}
				connectionClosed = true;
			}
			
			shutdownTCPIPServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Shutdown of communication socket failed: " + e);
		}
	}
	
	public synchronized void sendMessage(String mess) {
		if (out != null) {
			sending = true;
			
			try {
				out.writeBytes(mess + "\n");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sending = false;
			notifyAll();
		}
	}
}
