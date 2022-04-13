

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0]; /*tomamos el primer valor en la cadena de elementos que escribamos en terminal*/

        try {
            /*buscamos en rmi registry la direccion */
            Hello stub = (Hello)java.rmi.Naming.lookup("//" +java.net.InetAddress.getLocalHost().getHostAddress()+ ":1099/Hello");
            String response = stub.sayHello();/*mandamos a llamar al metodo sayHello*/
            System.out.println("respuesta: " + response);/*imprimimos la respuesta que recibimos de sayHello*/
        } catch (Exception e) {
            System.err.println("Excepcion del Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
