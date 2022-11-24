/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworldClient;

import hello.helloBeanRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author amnesia
 */
public class HelloWorldClient{
    public static void Main(String[] args) throws NamingException{
        Context ctx;
        ctx = new InitialContext();
    
        helloBeanRemote helloBean = (helloBeanRemote) ctx.lookup("java:global/HWEjbModule/helloBean!hello.helloBeanRemote");
        System.out.println(helloBean.sayHello("Antonio"));
    }
    
}
