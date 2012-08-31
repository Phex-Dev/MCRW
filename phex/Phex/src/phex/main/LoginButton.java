package phex.main;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;

public class LoginButton extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LoginButton(){
        super("Hello World! Version(2)");
        add("Center", new Button ( "Hello World"));
        pack();
        
       }
       public boolean handleEvent(Event evt){
        if(evt.id == Event.ACTION_EVENT){
               System.out.println("Hi, there!");
               }
        return true;
       }               
       public static void main(String argv[]){
       new LoginButton();
       }

}
