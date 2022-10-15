package org.example;

import java.rmi.Remote;

public interface Chat extends Remote {
    public void send(String msg, String name) throws java.rmi.RemoteException;

    public String receive() throws java.rmi.RemoteException;

    public void register(String name) throws java.rmi.RemoteException;
}
