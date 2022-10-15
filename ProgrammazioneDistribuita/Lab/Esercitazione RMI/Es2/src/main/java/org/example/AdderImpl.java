package org.example;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class AdderImpl extends UnicastRemoteObject implements Adder {

    private int sum = 0;
    static Logger logger = Logger.getLogger("global");

    //Costruttore che lancia l'eccezione RemoteException
    public AdderImpl() throws java.rmi.RemoteException {
        super();
    }

    public int add(int a) throws java.rmi.RemoteException {
        sum += a;
        return sum;
    }

    public int readSum() throws java.rmi.RemoteException {
        return sum;
    }

    public static void main(String[] args) throws RemoteException {
        AdderImpl adder = new AdderImpl();
        LocateRegistry.createRegistry(2020);
        logger.info("Server in ascolto sulla 2020...");
        try{
            Naming.rebind("//localhost:2020/adder", adder);
            logger.info("Bind effettuato...");
        }catch (Exception e){
            logger.severe("Errore: " + e.getMessage());
        }
        logger.info("Server pronto...");
    }
}

