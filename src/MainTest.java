import javax.swing.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.jupiter.api.*;
import java.sql.*;

public class MainTest {

	
	@Test
	public void ValidInputs() throws Exception {
		
		Main login = new Main();
		Field field = Main.class.getDeclaredField("usernameText");
		field.setAccessible(true);
		JTextField usernameText = new JTextField();
		usernameText.setText("HeroFoty1");
		
		// Check the state of the JTextField
		assertTrue(usernameText.getText().matches("[A-Z][a-z]+([A-Z])*([a-z]+)*"));
		
	}

	
}
