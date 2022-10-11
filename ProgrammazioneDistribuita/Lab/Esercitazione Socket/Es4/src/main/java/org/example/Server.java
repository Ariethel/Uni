package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logger logger = Logger.getLogger();
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        Object obj = ois.readObject();
        if (obj instanceof Pippo){
            oos.writeInt(0);
            logger.severe("Ricevuta istanza di Pippo");
        }
        else
            oos.writeInt(1);
    }
}
