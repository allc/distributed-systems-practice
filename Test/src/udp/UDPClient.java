package udp;
import java.io.IOException;
import java.net.*;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public class UDPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String message = "Hello world!";
		String hostName = "localhost";
		int serverPort = 29642;
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket();
			byte[] m = message.getBytes();
			InetAddress host = InetAddress.getByName(hostName);
			DatagramPacket request = new DatagramPacket(m, m.length, host, serverPort);
			socket.send(request);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			socket.receive(reply);
		} catch (SocketException e) {
			System.err.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO: " + e.getMessage());
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}

}
