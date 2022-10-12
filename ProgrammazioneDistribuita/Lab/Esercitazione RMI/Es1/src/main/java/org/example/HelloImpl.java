package org.example;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class HelloImpl extends UnicastRemoteObject implements HelloWorld{
    static Logger logger = Logger.getLogger("global");

    //Costruttore obbligatorio perche' deve lanciare l'eccezione remota
    public HelloImpl() throws RemoteException {
    }

    //Implementazione del metodo Hello
    public String Hello(String name) throws RemoteException {
        logger.info("Sto salutando: " + name);
        return "ciao!";
    }

    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            logger.info("Creo l'oggetto remoto...");
            HelloImpl obj = new HelloImpl();
            //Registrazione dell'oggetto remoto
            logger.info("registro l'oggetto remoto...");
            Naming.rebind("Hello", obj);
            logger.info("Server pronto");
        } catch (Exception e) {
            logger.info("Server non pronto");
            e.printStackTrace();
        }
    }
}
