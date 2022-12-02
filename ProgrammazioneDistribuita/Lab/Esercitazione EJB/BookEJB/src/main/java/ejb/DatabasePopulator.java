/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author amnesia
 */
@Singleton
@Startup
@LocalBean
@DataSourceDefinition(
className ="javax.persistence.schema-generation.database.action",
name ="java:app/BookEJBMysql",
user ="root",
password ="root",
databaseName ="BookEJB",
properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

    @Inject
    private BookEjb bookEJB;
    private Book h2g2, lord;
    
    @PostConstruct
    private void populateDB() {
        h2g2 = new Book("Beginning Java EE7", 35F, "Great book", "8763-9125-7", 605);
        lord = new Book("The Lord of the Rings", 50.4f, "SciFi", "84023-742-2", 1216);
        bookEJB.createBook(h2g2);
        bookEJB.createBook(lord);
    }
    
    @PreDestroy
    private void clearDB() {
        bookEJB.removeBook(h2g2);
        bookEJB.removeBook(lord);
    }
}
