package cs544.exercise23_1.server;

public class CalculatingService implements ICalculate {
 private int retval=0;

    public String getMessage(Person person) {
        System.out.println("RMI Server object receiving person with name "
                + person.getFirstName() + " " + person.getLastName());

        return "Hello " + person.getFirstName() + " " +person.getLastName();
        
    }

    public  int calc(char operator, int number) {
        
       
         switch (operator) {
            case '+':
                retval += 58 + number;
                break;
            case '-':
                retval += 58 - number;
                break;
            case '/':
                retval += 58 / number;
                break;
            case '*':
                retval += 58 * number;
                break;
            default:
                retval = 0;

        }
        return retval;
    }
}
