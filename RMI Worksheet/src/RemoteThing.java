import java.rmi.*;
import java.rmi.server.*;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public class RemoteThing extends UnicastRemoteObject implements RemoteThingInterface {
	
	public RemoteThing() throws RemoteException {
		super();
	}

	/* (non-Javadoc)
	 * @see RemoteThingInterface#accessThing()
	 */
	@Override
	public String accessThing() throws RemoteException {
		return "Hello world!";
	}

}
