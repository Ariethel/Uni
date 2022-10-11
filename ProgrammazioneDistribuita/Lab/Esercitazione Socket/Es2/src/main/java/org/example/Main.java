package org.example;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert a number: ");
        a = sc.nextInt();
        Socket socket = new Socket("localhost", 9000);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        oos.writeInt(a);
        int sum = ois.readInt();
        System.out.println("Sum: " + sum);
        socket.close();
    }
}