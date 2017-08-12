import java.rmi.*;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public class RemoteThingServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RemoteThing remoteThing = new RemoteThing();
			Naming.bind("remoteThing", remoteThing);
			System.out.println("remoteThing ready");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
