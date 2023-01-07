package canzoneSanremo;

import javax.enterprise.event.Observes;

public class UpdateNotification {
    public void notify(@Observes Canzone o){
        System.out.println(o.getId() +" has been updated");
    }
}
