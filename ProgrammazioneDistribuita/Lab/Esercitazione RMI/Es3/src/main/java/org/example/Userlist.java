package org.example;

import java.rmi.Remote;
import java.util.ArrayList;

public interface Userlist extends Remote {
    public void addUser(Utente u) throws java.rmi.RemoteException;

    public ArrayList<Utente> getUsers() throws java.rmi.RemoteException;

    public int removeUser(Utente u) throws java.rmi.RemoteException;

}
