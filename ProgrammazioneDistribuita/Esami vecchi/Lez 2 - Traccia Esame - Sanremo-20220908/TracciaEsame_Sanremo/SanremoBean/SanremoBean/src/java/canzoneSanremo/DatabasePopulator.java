package canzoneSanremo;

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
   user = "ok", password = "ok",
   databaseName = "EsameDB",
   properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    
    @Inject
    private CanzoneEJB ejb;
    private Canzone c1, c2, c3;
    
    @PostConstruct
    private void populateDB(){
        c1 = new Canzone(1, "Diodato", "Pop", "Sai che cosa penso, Che non dovrei pensare, Che se poi penso sono un animale. E se ti penso tu sei un'anima,", Boolean.FALSE, 1000);
        c2 = new Canzone(2, "Piero Pelù", "Rock", "Spingi forte spingi forte salta fuori da quel buio. Crescerai aprendo porte tutti i giorni stare pronti", Boolean.FALSE, 13);
        c3 = new Canzone(3, "Bugo e Morgan", "Pop", "Le buone intenzioni, l'educazione. La tua foto profilo, buongiorno e buonasera. E la gratitudine, le circostanze. Bevi se vuoi ma fallo responsabilmente", Boolean.FALSE, 5000);
        
        ejb.aggiungiCanzone(c1);
        ejb.aggiungiCanzone(c2);
        ejb.aggiungiCanzone(c3);
    }
    
    @PreDestroy
    private void clearDB(){
        ejb.eliminaCanzone(c1);
        ejb.eliminaCanzone(c2);
        ejb.eliminaCanzone(c3);
    }
    
    
}
