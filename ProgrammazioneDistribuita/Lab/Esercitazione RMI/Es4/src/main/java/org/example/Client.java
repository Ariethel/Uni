package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Chat obj = (Chat) Naming.lookup("//localhost:2020/Chat");
        while(true){
            System.out.println(" 1 - Send message\n 2 - Receive message\n 3 - Register");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter your name: ");
                    String name = sc.next();
                    System.out.println("Enter your message: ");
                    String msg = sc.next();
                    obj.send(msg, name);
                    break;
                case 2:
                    System.out.println(obj.receive());
                    break;
                case 3:
                    System.out.println("Enter your name: ");
                    String name1 = sc.next();
                    obj.register(name1);
                    break;
                default:
                    break;
            }
        }
    }
}