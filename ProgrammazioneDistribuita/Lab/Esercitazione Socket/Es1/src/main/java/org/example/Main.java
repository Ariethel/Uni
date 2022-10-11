package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("client started...");
        Socket socket = new Socket("localhost", 9000);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(true) {
            flag = scanner.nextBoolean();
            oos.writeBoolean(flag);
            if (!flag) break;
            System.out.println("Inserire a: ");
            oos.writeObject(scanner.nextInt());
            System.out.println("Inserire b: ");
            oos.writeObject(scanner.nextInt());
            System.out.println("a + b = " + oi.readInt());
        }
        socket.close();

        System.out.println("client disconnected...");
    }
}