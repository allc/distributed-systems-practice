/**
 * 
 */
package udpExample;

import java.net.*;

/**
 * @author Allen
 *
 */
public class UDPSender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("localhost");
			DatagramSocket socket = new DatagramSocket();
			for (int i = 0; i < 10; i++) {
				byte[] buf = String.valueOf(i).getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4321);
				socket.send(packet);
				System.out.println("send DatagramPacker " + new String(packet.getData()) + " " + packet.getAddress() + ":" + packet.getPort());
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
