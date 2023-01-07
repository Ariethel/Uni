package dpcm;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
   className = "org.apache.derby.jdbc.EmbeddedDataSource",
   name = "java:global/jdbc/EsameDS",
   user = "app", password = "app",
   databaseName = "EsameDB",
   properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    
    @Inject
    private DecretoEJB ejb;
    private Decreto d1, d2, d3;
    
    @PostConstruct
    private void populateDB(){
        d1 = new Decreto(1, "Decreto CoronaVirus", "Covid", "Sanitaria", "1", 12);
        d2 = new Decreto(2, "Fine del mondo", "Diluvio", "Fine del mondo", "1", 1);
        d3 = new Decreto(3, "Arrivo della peste nera", "Peste", "Sanitaria", "2", 8);
        
        ejb.aggiungiDecreto(d1);
        ejb.aggiungiDecreto(d2);
        ejb.aggiungiDecreto(d3);
    }
    
    @PreDestroy
    private void clearDB(){
        ejb.eliminaDecreto(d1);
        ejb.eliminaDecreto(d2);
        ejb.eliminaDecreto(d3);
    }
    
    
}
