/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package hello;

import javax.ejb.Stateless;

/**
 *
 * @author amnesia
 */
@Stateless
public class HelloBean implements HelloBeanRemote {

    public String sayHello(String name){
        return "Hello " + name;
    }
}
