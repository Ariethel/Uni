package dpcmjmsclient;

import dpcm.MessageWrapper;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DPCMJMSClient {

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ConnectionFactory connectionFactory = (ConnectionFactory)
                ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) 
                ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper wrapper = new MessageWrapper(1, 3);
        try(JMSContext jmsContext = connectionFactory.createContext()){
            jmsContext.createProducer().send(topic, wrapper);
        }
    }
}
