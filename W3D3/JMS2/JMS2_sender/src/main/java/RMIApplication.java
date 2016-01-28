
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zehafta M
 */
public class RMIApplication {
    	public static void main(String[] args) {
		@SuppressWarnings("unused")
	   ApplicationContext context = new ClassPathXmlApplicationContext(
                    "springserviceconfig.xml");
		System.out.println("Server is running ...");
	}
}
