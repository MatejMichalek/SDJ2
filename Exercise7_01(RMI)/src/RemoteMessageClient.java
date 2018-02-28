import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RemoteMessageClient implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private RemoteMessageList list;
	
	public RemoteMessageClient(String msg) throws Exception{
		super();
		list=(RemoteMessageList) Naming.lookup("rmi://localhost:1099/addMessage");
		list.addMessage(msg);
	}
	public static void main(String[] args) throws Exception {
		RemoteMessageClient client=new RemoteMessageClient("test");
	}
}
