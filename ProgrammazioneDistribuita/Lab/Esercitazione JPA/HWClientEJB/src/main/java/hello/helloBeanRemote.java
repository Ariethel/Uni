/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package hello;

import javax.ejb.Remote;

/**
 *
 * @author amnesia
 */
@Remote
public interface helloBeanRemote {
    String sayHello(String name);
}
