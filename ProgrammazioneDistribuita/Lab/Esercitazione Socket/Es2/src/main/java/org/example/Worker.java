package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Worker implements Runnable{

    public Worker(Socket socket){this.socket = socket;}
    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            int a = ois.readInt();
            synchronized (this.sum){
                sum += a;
                int z = sum;
                oos.writeInt(z);
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Integer sum=0;
    private Socket socket;
}
