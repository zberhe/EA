package cs544.jms.receiver;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JMSTaxApp {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigreceiver.xml");
		System.out.println("JMS receiver is running ...");
	}

}

