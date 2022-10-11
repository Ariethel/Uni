package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements HelloWorld {
    protected Server() throws RemoteException {
    }

    public String Hello(String name) throws java.rmi.RemoteException {
        return "Hello World!" + name;
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException {
        System.out.println("Creazione oggetto remoto");
        Server obj = new Server();

        System.out.println("bind()");

        Naming.rebind("HelloWorld", obj);

        System.out.println("Server pronto");
    }
}