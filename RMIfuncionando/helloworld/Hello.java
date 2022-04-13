
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {/*interface hello */
    String sayHello() throws RemoteException;/*metodo  que dice hola*/
}
