package org.example;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ChatImpl extends UnicastRemoteObject implements Chat {
    private ArrayList<String> msg = new ArrayList<>();
    private ArrayList<String> utenti = new ArrayList<>();
    static Logger logger = Logger.getLogger("Global");

    @Override
    public void register(String name) throws RemoteException {
        utenti.add(name);
    }

    public ChatImpl() throws java.rmi.RemoteException {
        super();
    }

    public void send(String msg, String name) throws java.rmi.RemoteException {
        this.msg.add(name + ": " + msg);
    }

    public String receive() throws java.rmi.RemoteException {
        return this.msg.toString();
    }

    public static void main(String[] args) throws RemoteException {
        ChatImpl chat = new ChatImpl();
        LocateRegistry.createRegistry(2020);
        logger.info("Server in ascolto sulla 2020...");
        try {
            Naming.rebind("//localhost:2020/Chat", chat);
            logger.info("Bind effettuato correttamente...");
        }catch (Exception e){
            logger.severe("Errore nel bind...");
        }

        logger.info("Server pronto...");



    }
}
