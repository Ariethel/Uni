package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            Worker worker = new Worker(socket);
            Thread thread = new Thread(worker);
            thread.start();
        }
    }
}

