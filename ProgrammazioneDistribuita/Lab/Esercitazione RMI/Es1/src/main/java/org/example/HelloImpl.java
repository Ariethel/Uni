package org.example;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
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

            //In questo modo rmiregistry parte da solo nella classpath del server, non e' necessario avviarlo
            //separatamente
            LocateRegistry.createRegistry(2020);
            logger.info("Registry partito...");

            logger.info("faccio il bind...");
            try{
                //Necessario mettere anche la porta accanto al nome del server
                Naming.rebind("//localhost:2020/Hello", hello);
            }catch (Exception e) {
                e.printStackTrace();
            }
            logger.info("server pronto...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
