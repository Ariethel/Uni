package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Userlist obj = (Userlist) Naming.lookup("//localhost:2020/Userlist");
        System.out.println("Inserire un utente: ");
        Scanner sc = new Scanner(System.in);
        Utente u = new Utente(sc.nextLine());
        obj.addUser(u);
        System.out.println("Utente " + u.getNome() + " aggiunto correttamente");
        System.out.println("Utenti presenti: ");
        for (Utente us : obj.getUsers()){
            System.out.println(us.getNome());
        }

        System.out.println("Inserire un utente da rimuovere: ");
        Utente u2 = new Utente(sc.nextLine());
        System.out.println("Rimozione utente ha restituito: " + obj.removeUser(u2));
        System.out.println("Utenti presenti: ");
        for (Utente us : obj.getUsers()){
            System.out.println(us.getNome());
        }
    }
}