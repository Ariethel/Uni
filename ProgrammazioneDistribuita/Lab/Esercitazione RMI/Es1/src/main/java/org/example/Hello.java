package org.example;
import java.rmi.Remote;

public interface Hello extends Remote{
    String sayHello(String name) throws java.rmi.RemoteException;
}

