package org.example;

import java.rmi.Remote;

public interface Adder extends Remote {

    public int add(int a) throws java.rmi.RemoteException;

    public int readSum() throws java.rmi.RemoteException;
}
