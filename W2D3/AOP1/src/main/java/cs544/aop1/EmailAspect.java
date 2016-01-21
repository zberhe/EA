package cs544.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

@Aspect
public class EmailAspect {

	@After("execution(public void cs544.aop1.EmailSender.*(..) )")
     	public void emailAdvice(JoinPoint jpoint){
		System.out.println("Method:"+jpoint.getSignature().getName());
                Object[] args = jpoint.getArgs();
                String email = (String)args[0];
                String message = (String)args[1];
                
                System.out.println("Email: "+email + "  Message : "+message);
               EmailSender eSender = (EmailSender)jpoint.getTarget();
               System.out.println("outgoing mail server"+eSender);
}
        @Around("execution(public * cs544.aop1.*.*(..))")
        public Object invoke(ProceedingJoinPoint call) throws Throwable{
            StopWatch sw = new StopWatch("");
            sw.start(call.getSignature().getName());
            Object retval = call.proceed();
            sw.stop();
            long totaltime = sw.getLastTaskTimeMillis();
            System.out.println("Total time to execute save: "+totaltime);
            return retval;
            
            
        }
        
	
	
}
