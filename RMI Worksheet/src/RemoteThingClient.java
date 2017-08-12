import java.rmi.Naming;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public class RemoteThingClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RemoteThingInterface remoteThing = (RemoteThingInterface) Naming.lookup("rmi://localhost/remoteThing");
			System.out.println("remoteThing found");
			System.out.println(remoteThing.accessThing());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
