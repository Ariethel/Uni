/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author amnesia
 */
@Stateless
@LocalBean
public class BookEjb implements BookEjbRemote {
    @Inject
    private EntityManager em;
    
    
    public List<Book> findBooks(){
        TypedQuery<Book> query = em.createNamedQuery("FIND_ALL", Book.class);
        return query.getResultList();
    }
    
    public @NotNull Book createBook(@NotNull Book book){
        em.persist(book);
        return book;
    }
    
    public @NotNull Book updateBook(@NotNull Book book){
        em.merge(book);
        return book;
    }
    
    public @NotNull void removeBook(@NotNull Book book){
        em.remove(em.merge(book));
    }
    
    
}
