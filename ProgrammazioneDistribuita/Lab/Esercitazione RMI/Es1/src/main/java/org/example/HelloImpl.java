package org.example;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class HelloImpl extends UnicastRemoteObject implements Hello{
    private static final long serialVersionUID = 1L;
    static Logger logger = Logger.getLogger("global");
    public HelloImpl() throws RemoteException {
        super();
    }
    public String sayHello(String name) throws RemoteException {
        logger.info("Sto salutando: " + name);
        return "Ciao!";
    }

    public static void main(String[] args) {
        try {
            logger.info("Server partito...");
            HelloImpl hello = new HelloImpl();
            logger.info("faccio il bind...");
            Naming.rebind("Hello", hello);
            logger.info("server pronto...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
