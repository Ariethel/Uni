package org.example;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            Hello obj = (Hello) Naming.lookup("rmi://localhost:2020/Hello");
            System.out.println(obj.sayHello("Antonio"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}