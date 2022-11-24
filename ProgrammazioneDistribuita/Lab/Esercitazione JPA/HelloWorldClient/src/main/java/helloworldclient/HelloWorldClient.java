package helloworldclient;

import hello.HelloBeanRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author amnesia
 */
public class HelloWorldClient {

    public static void main(String[] args) throws NamingException{
        Context ctx;
        ctx = new InitialContext();
        HelloBeanRemote helloBean = (HelloBeanRemote) ctx.lookup("java:global/HelloWorldBean/HelloBean!hello.HelloBeanRemote");
        System.out.println(helloBean.sayHello("Antonio"));
        
    }
}
