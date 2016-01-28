package cs544.jms1.receiver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Zehafta M
 */
public class Calculator implements MessageListener{

    private int retval = 0;

    public int calc(char operator, int number) {

        switch (operator) {
            case '+':
                retval += number;
                break;
            case '-':
                retval -= number;
                break;
            case '/':
                retval /=  number;
                break;
            case '*':
                retval *= number;
                break;
            default:
                retval = 0;

        }
        return retval;
    }
      public void onMessage(Message message){
    	ObjectMessage objmessage = (ObjectMessage)message;
    	try {
			Character character = (Character)objmessage.getObject();
			System.out.println("Calculator receives message with command : " +character);
                        System.out.println(character + "command applied to 8");
                        System.out.println(calc((char)character,8));
                        System.out.println("Calculator result after second time ");
                          System.out.println(calc((char)character,8));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
