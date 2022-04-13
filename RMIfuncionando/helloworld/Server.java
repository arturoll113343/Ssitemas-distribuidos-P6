
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {/*implementamos la interfaz*/

    public Server() {}

    public String sayHello() {//regresamos este mensaje al cliente
        return "Hola, Mundo en sistemas distribuidos desde el Servidor, esto podria ser Amazon respondiendo un proceso de pago!";
    }

    public static void main(String args[]) {/*conectividad con el cliente*/

        try {
            Server obj = new Server();/*instanciamos la clase actual -> crear un objeto */
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);/*interfaz exportando el objeto server y el puertode la VM PARA TRANSFERIRLO al cliente */

            // Enlazar el stub del objeto remoto en el registro
        //Naming proporciona métodos para almacenar y obtener referencias a objetos remotos en un registro de objetos remotos.
            java.rmi.Naming.rebind("//" +java.net.InetAddress.getLocalHost().getHostAddress()+ ":1099/Hello", stub);/*enlazarlo usando el 	protocolo rmi + dureccion y nombre de la computadora y el puerto + stub(interfaz)*/
//localhost/1099/hELLO
       

            System.err.println("el servidor esta listo y acepta conexiones");//IMPRIMIR EN EL SERVER

        } catch (Exception e) {//en caso de que no logre crear el sertvidor o el stub

            System.err.println("Excepcion del Servidor : " + e.toString());
            e.printStackTrace();

        }
    }
}
