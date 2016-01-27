package cs544.rmi;

import cs544.sh1.bank.domain.Account;
import cs544.sh1.bank.domain.AccountEntry;
import cs544.sh1.bank.domain.Customer;
import cs544.sh1.bank.service.IAccountService;
import java.util.Collection;
import org.springframework.util.StopWatch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springconfigclient.xml");
        IAccountService remoteServer = context
                .getBean("accountService", IAccountService.class);

        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
      
        remoteServer.createAccount(1263862, "Frank Brown");
            remoteServer.createAccount(4253892, "John Doe");
            // use account 1;
            remoteServer.deposit(1263862, 240);
            remoteServer.deposit(1263862, 529);
            remoteServer.withdrawEuros(1263862, 230);
            // use account 2;
            remoteServer.deposit(4253892, 12450);
            remoteServer.depositEuros(4253892, 200);
            remoteServer.transferFunds(4253892, 1263862, 100,
                    "payment of invoice 10232");
            // show balances

            Collection<Account> accountlist = remoteServer.getAllAccounts();

            Customer customer = null;
            for (Account account : accountlist) {
                customer = account.getCustomer();
                System.out.println("Statement for Account: "
                        + account.getAccountnumber());
                System.out.println("Account Holder: " + customer.getName());
                System.out.println("-Date-------------------------"
                        + "-Description------------------"
                        + "-Amount-------------");
                for (AccountEntry entry : account.getEntryList()) {
                    System.out.printf("%30s%30s%20.2f\n", entry.getDate()
                            .toString(), entry.getDescription(), entry
                            .getAmount());
                }
                System.out.println("----------------------------------------"
                        + "----------------------------------------");
                System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
                        account.getBalance());
            }

        stopwatch.stop(); // optional
        long millis = stopwatch.getTotalTimeMillis();
        System.out.println("Total Time elapsed per request: " + millis);
        // System.out.println("Receiving result: " + result);
    }

}
