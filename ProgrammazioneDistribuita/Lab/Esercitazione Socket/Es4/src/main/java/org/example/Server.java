package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        Object obj = ois.readObject();
        System.out.println("il client ha inviato " + obj.toString());
        if (obj instanceof Pippo){
            oos.writeInt(0);
            System.out.println("Ricevuta istanza di Pippo");
        }
        else
            oos.writeInt(1);
    }
}
