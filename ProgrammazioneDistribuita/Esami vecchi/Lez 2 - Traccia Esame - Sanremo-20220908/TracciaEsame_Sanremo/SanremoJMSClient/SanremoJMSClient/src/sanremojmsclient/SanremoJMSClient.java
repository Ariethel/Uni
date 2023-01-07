package sanremojmsclient;

import canzoneSanremo.MessageWrapper;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SanremoJMSClient {

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ConnectionFactory connectionFactory = (ConnectionFactory)
                ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) 
                ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper wrapper1 = new MessageWrapper(1, "Diodato", "Sai che cosa penso");
        MessageWrapper wrapper2 = new MessageWrapper(3, "Bugo e Morgan", "Le mettendo i piedi in testa");
        try(JMSContext jmsContext = connectionFactory.createContext()){
            jmsContext.createProducer().send(topic, wrapper1);
            jmsContext.createProducer().send(topic, wrapper2);
        }
    }
    
}

