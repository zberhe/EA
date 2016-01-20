/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.AutoWiringByConstructor;

/**
 *
 * @author Zehafta M
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("springconfig.xml");

      TextEditor te = context.getBean("textEditor",TextEditor.class);

      te.spellCheck();
   }
}
