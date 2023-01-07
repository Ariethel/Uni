package canzoneSanremo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic", 
    activationConfig = {
        @ActivationConfigProperty(propertyName="acknowledgeMode",propertyValue = "Auto-acknowledge")
})
public class CanzoneMDB implements MessageListener{
    @Inject 
    Event<Canzone> generalEvent;
    
    @Inject @MorganQualifier
    Event<Canzone> morganEvent;
    
    @Inject
    private CanzoneEJB ejb;

    @Override
    public void onMessage(Message msg) {
        try{
            MessageWrapper msgContent = msg.getBody(MessageWrapper.class);
            Integer id = msgContent.getID();
            
            Canzone c = ejb.trovaPerId(id);
            System.out.println(c);
            if(c.getIncipit().startsWith(msgContent.getPrimeParole())){
                c.setCantato(Boolean.TRUE);
                generalEvent.fire(c);
            }

            if(msgContent.getCantante().equals("Bugo e Morgan") & 
                msgContent.getPrimeParole().equals("Le mettendo i piedi in testa")){
                    c.setCantato(true);
                    c.setNomeCantante("Morgan");
                    morganEvent.fire(c);
            }

            ejb.aggiornaCanzone(c);
        } catch (JMSException ex) {
            Logger.getLogger(CanzoneMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
