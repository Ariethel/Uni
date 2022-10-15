package org.example;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Logger;

public class UserlistImpl extends UnicastRemoteObject implements Userlist {
    public UserlistImpl() throws java.rmi.RemoteException {
        super();
        users = new ArrayList<Utente>();
    }

    public void addUser(Utente u) throws java.rmi.RemoteException {
        users.add(u);
    }

    public ArrayList<Utente> getUsers() throws java.rmi.RemoteException {
        return users;
    }

    public int removeUser(Utente u) throws java.rmi.RemoteException {
        for (Utente us : users){
            if (us.getNome().equals(u.getNome())){
                users.remove(us);
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws RemoteException {
        UserlistImpl userlist = new UserlistImpl();
        LocateRegistry.createRegistry(2020);
        logger.info("Server in ascolto sulla 2020...");
        try{
            Naming.rebind("//localhost:2020/Userlist", userlist);
            logger.info("Bind eseguito correttamente...");
        }catch (Exception e){
            logger.severe("Errore: " + e.getMessage());
        }
        logger.info("Server pronto...");
    }

    static Logger logger = Logger.getLogger("global");
    private ArrayList<Utente> users;
}
