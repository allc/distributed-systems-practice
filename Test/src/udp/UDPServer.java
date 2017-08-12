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
public class UDPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(29642);
			byte[] buffer = new byte[1000];
			while (true) {
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				socket.receive(request);
				System.out.println(new String(request.getData()));
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
				socket.send(reply);
			}
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
