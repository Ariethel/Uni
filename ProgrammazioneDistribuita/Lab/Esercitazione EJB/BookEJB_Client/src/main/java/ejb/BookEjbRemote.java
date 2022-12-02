/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author amnesia
 */
@Remote
public interface BookEjbRemote {
    List<Book> findBooks();
    Book createBook(Book book);
    Book updateBook(Book book);
    void removeBook(Book book);
    
}
