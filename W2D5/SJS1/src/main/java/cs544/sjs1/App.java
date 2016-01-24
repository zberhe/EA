package cs544.sjs1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");  
                        BillingService billingService = context.getBean("billingService",BillingServiceImpl.class);
                        billingService.generateBillingReport();
                        billingService.printBills();
                        
	}
}
