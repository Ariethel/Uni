package dpcm;

import javax.enterprise.event.Observes;

public class UpdateNotification {
    public void notify(@Observes Decreto d){
        System.out.println("Dati aggiornati");
    }
}
