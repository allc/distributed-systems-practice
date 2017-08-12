import java.rmi.*;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public interface RemoteThingInterface extends Remote {

	public String accessThing() throws RemoteException;
	
}
