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
public class TCPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String host = "localhost";
		String message = "Hello world!";
		
		Socket s = null;
		try {
			int serverPort = 7896;
			s = new Socket(host, serverPort);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(message);
			String data = in.readUTF();
			System.out.println("Received: " + data);
		} catch (UnknownHostException e) {
			System.err.println("Sock: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO: " + e.getMessage());
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					System.err.println("close: " + e.getMessage());
				}
			}
		}
	}

}
