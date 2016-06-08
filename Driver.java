import java.sql.Date;

import javax.swing.UIManager;

public class Driver {
	
	private static Controller controller;	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{ 
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
		} 
		catch(Exception e){ 
		}
		
		GUI gui = new GUI();
		Scorecard scorecard = new Scorecard();
		Controller controller = new Controller(gui, scorecard);
		
		
		
	}
}

