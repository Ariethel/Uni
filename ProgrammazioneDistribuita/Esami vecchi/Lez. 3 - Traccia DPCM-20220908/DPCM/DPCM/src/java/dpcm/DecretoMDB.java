package dpcm;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class DecretoMDB implements MessageListener{
    @Inject 
    Event<Decreto> e;
    
    @Inject
    private DecretoEJB ejb;
    
    @Override
    public void onMessage(Message msg) {
        try{
            MessageWrapper msgContent = msg.getBody(MessageWrapper.class);
            Integer id = msgContent.getId();
            Integer incremento = msgContent.getAggiornamento_numero_presentazioni();
            
            Decreto d = ejb.trovaPerId(id);
            d.setNumero_presentazioni_stampa(d.getNumero_presentazioni_stampa()+incremento);

            ejb.aggiornaDecreto(d);
            
            e.fire(d);
        } catch (JMSException ex) {
            Logger.getLogger(DecretoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
