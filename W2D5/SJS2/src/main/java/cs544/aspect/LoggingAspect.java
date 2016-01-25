/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.aspect;

import cs544.bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

/**
 *
 * @author Zehafta M
 */
@Aspect
public class LoggingAspect {

    Logger logger;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Before("execution(public * cs544.bank.dao.*.*(..))")
    public void methodCallLogger(JoinPoint joinPoint) {
        System.out.println("A method in bank.dao package got called:" + joinPoint.getSignature().getName());
    }

        @Around("execution(public * cs544.bank.service.*.*(..))")
	public Object measureInvocationTime(ProceedingJoinPoint call) throws Throwable{
		StopWatch clock = new StopWatch();
                
            clock.start(call.getSignature().getName());
            Object retval = call.proceed();
            clock.stop();
            long totaltime = clock.getLastTaskTimeMillis();
            System.out.println("Total time to execute: "+call.getSignature().getName()+":   "+totaltime);
            return retval;
                
	}
    @AfterReturning("execution(public * cs544.bank.service.AccountService.createAccount(..) ) && args(accountNumber,customerName)")
    public void logCreatedAccount(JoinPoint joinPoint, long accountNumber, String customerName) {

        logger.log("\ncreateAccount with parameters accountNumber= " + accountNumber + " ,customerName= " + customerName + "\n");
    }

    @AfterReturning("execution(public * cs544.bank.service.AccountService.deposit*(..) ) && args(accountNumber,amount)")
    public void logDeposit(JoinPoint joinPoint, long accountNumber, double amount) {

        logger.log("\ndeposit with parameters accountNumber= " + accountNumber + " , amount= " + amount + "\n");
    }

    @AfterReturning("execution(public * cs544.bank.service.AccountService.withdraw*(..) ) && args(accountNumber,amount)")
    public void logWithdraw(JoinPoint joinPoint, long accountNumber, double amount) {

        logger.log("\nwithdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount + "\n");
    }

    @AfterReturning("execution(public * cs544.bank.service.AccountService.transferFunds(..) ) && args(fromAccountNumber, toAccountNumber, amount, description)")
    public void logTransferFund(JoinPoint joinPoint, long fromAccountNumber, long toAccountNumber, double amount, String description) {

        logger.log("\ntransferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= " + toAccountNumber + " , amount= " + amount + " , description= " + description+"\n");
    }

    @AfterReturning("execution(public * cs544.bank.jms.JMSSender.sendJMSMessage(..) )&& args(text)")
    public void logSentJMS(JoinPoint joinPoint, String text) {
        logger.log("\nJMS message sent: "
                + text + "\n");
    }
}
