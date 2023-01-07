package dpcm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.enterprise.inject.Produces;

public class DatabaseProducer {
    
    @Produces
    @PersistenceContext(unitName = "EsamePU")
    private EntityManager em;
    
}
