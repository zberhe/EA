package cs544.exercise23_1.client;

import org.springframework.util.StopWatch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cs544.exercise23_1.server.Person;
import cs544.exercise23_1.server.ICalculate;

public class RMIClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springconfigclient.xml");
        ICalculate remoteServer = context
                .getBean("helloserver", ICalculate.class);
        Person person = new Person("John", "Doe");
        StopWatch stopwatch = new StopWatch();

     
       // String result = remoteServer.getMessage(person);
        System.out.println("+" + remoteServer.calc('+', 5));
        System.out.println("+" + remoteServer.calc('+', 5));
           stopwatch.stop(); // optional
        long millis = stopwatch.getTotalTimeMillis();
        System.out.println("Total Time elapsed per request: "+millis);
       // System.out.println("Receiving result: " + result);
    }

}
