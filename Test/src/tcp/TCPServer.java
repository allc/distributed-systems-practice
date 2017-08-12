/**
 * 
 */
package tcp;

import java.io.*;
import java.net.*;

/**
 * @author Allen
 *
 */
public class TCPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int serverPort = 7896;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while (true) {
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		} catch (IOException e) {
			System.err.println("Listen: " + e.getMessage());
		}
	}

}

class Connection extends Thread {
	
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	
	public Connection(Socket clientSocket) {
		try {
			this.clientSocket = clientSocket;
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("Connection: " + e.getMessage());
		}
	}
	
	public void run() {
		try {
			String data = in.readUTF();
			out.writeUTF(data);
		} catch (EOFException e) {
			System.err.println("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO: " + e.getMessage());
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				
			}
		}
	}
	
}