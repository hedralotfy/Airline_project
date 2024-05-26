import javax.swing.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;


public class AddCostumerTest {
	
	@Test
	public void ValidInputs() throws Exception {
		// Create a JTextField
		

		//Last modified on 10-5-2024
	    AddCostumer addCostumer = new AddCostumer();
	    
	    Field field = AddCostumer.class.getDeclaredField("fName");
	    field.setAccessible(true);
        JTextField fName = new JTextField();

        field = AddCostumer.class.getDeclaredField("lName");
        field.setAccessible(true);
        JTextField lName = new JTextField();
        
        field = AddCostumer.class.getDeclaredField("userTxt");
        field.setAccessible(true);
        JTextField userTxt = new JTextField();
        
        field = AddCostumer.class.getDeclaredField("phoneTxt");
        field.setAccessible(true);
        JTextField phoneTxt = new JTextField();
        
        field = AddCostumer.class.getDeclaredField("ageTxt");
        field.setAccessible(true);
        JTextField ageTxt = new JTextField();



        // Simulate user input
        // FirstName should start with capital letter followed by lowercase letters only
        
        fName.setText("Egypto");
        // LastName should start with capital letter followed by lowercase letters only
        
        lName.setText("Dad");//
     // UserName can start with capital letter followed by lowercase letters or the same thing and can be followed by
        //Capital letter again  
        userTxt.setText("DaaD");
        
        //Phone number should start with 0 followed by any number from 1 to 9 10 times
        phoneTxt.setText("01278152658");
        
        //Age should be greater than 0
        ageTxt.setText("-16"); //<- Wrong value
        
        String ageText = ageTxt.getText();
        int age = Integer.valueOf(ageText);
        

        // Check the state of the JTextField
//        assertEquals("Egypto", fName.getText());
        assertTrue(fName.getText().matches("[A-Z][a-z]+"));
        assertTrue(lName.getText().matches("[A-Z][a-z]+"));
        assertTrue(userTxt.getText().matches("[A-Z][a-z]+([A-Z])*([a-z]+)*")); //Correction in the test value
        assertTrue(phoneTxt.getText().matches("0[1-9]{10}"));
        assertTrue("the number should be greater than 0", age > 0);
        
	}

}
