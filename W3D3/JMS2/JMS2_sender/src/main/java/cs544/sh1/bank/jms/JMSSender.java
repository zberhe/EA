package cs544.sh1.bank.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


public class JMSSender implements IJMSSender{
	    private JmsTemplate jmsTemplate;
       public void sendJMSMessage(final String c) {
        jmsTemplate.send(new MessageCreator() {
              public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(c);
              }
        });            
        System.out.println("Sending message with command : " +c);
    }
//    public void send(final Person person) {
//        jmsTemplate.send(new MessageCreator() {
//              public Message createMessage(Session session) throws JMSException {
//                return session.createObjectMessage(person);
//              }
//        });            
//        System.out.println("Sending message with person object : " + person.getFirstName()+" "+person.getLastName());
//    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
	

}
