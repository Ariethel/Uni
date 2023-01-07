package canzoneSanremo;

import javax.enterprise.event.Observes;

public class MorganNotification {
     public void notify(@Observes @MorganQualifier Canzone o){
        System.out.println("Dove è andato Bugo?");
    }
}
