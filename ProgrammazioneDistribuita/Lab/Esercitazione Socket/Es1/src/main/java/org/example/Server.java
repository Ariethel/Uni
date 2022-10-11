package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("server started...");
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        System.out.println("client connected...");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
        while(oi.readBoolean()) {
            int a = oi.readInt();
            int b = oi.readInt();
            oos.writeInt(a + b);
        }
        socket.close();

        System.out.println("client disconnected...");
    }
}
