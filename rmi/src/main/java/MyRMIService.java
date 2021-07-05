import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRMIService extends Remote {
    public String helloTo(String name) throws RemoteException;
}
