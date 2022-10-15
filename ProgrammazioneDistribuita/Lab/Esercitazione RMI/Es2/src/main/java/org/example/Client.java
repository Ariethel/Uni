package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Adder obj = (Adder) Naming.lookup("//localhost:2020/adder");
        System.out.println("Passare un intero al server: ");
        Scanner sc = new Scanner(System.in);
        obj.add(sc.nextInt());
        System.out.println("Somma: " + obj.readSum());

    }
}