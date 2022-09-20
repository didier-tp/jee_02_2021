package tp.core.bs.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * NB: Jboss EAP ou Wildfly doit etre demarre en version standalone-full.xml
 *     pour gérer JMS et les EJB de type MDB.
 * Message-Driven Bean implementation class for: MyMDB , simple destination/queue name (ex: "myQueue" without "jms/" )
 * 
 * <jms-queue name="myQueue" entries="java:jboss/exported/jms/queue/myQueue   java:/jms/queue/myQueue"/>
 * a idealement ajouter dans standalone-full.xml
 * 
 */
@MessageDriven(	activationConfig = {
		@ActivationConfigProperty(	propertyName = "destination", propertyValue = "myQueue"), 
		@ActivationConfigProperty(	propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		})
public class MyMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public MyMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {	
      try {
		  if(message instanceof TextMessage){
			  TextMessage txtMsg = (TextMessage) message;
			  System.out.println("received message = " + txtMsg.getText());
		  }
	} catch (JMSException e) {
		e.printStackTrace();
	}
    }

}
