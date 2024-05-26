import static org.junit.Assert.*;

import java.lang.reflect.Field;

import javax.swing.JSpinner;

import org.junit.Test;

public class TicketBookingTest {

	@Test
	public void test() throws Exception{
		TicketBooking ticket = new TicketBooking();
		Field field = TicketBooking.class.getDeclaredField("seatsTxt");
		field.setAccessible(true);
		
		JSpinner seatsTxt = new JSpinner();
		
		seatsTxt.setValue(3);
	    // set the value of 'seatsTxt' in the 'ticket' instance
	    field.set(ticket, seatsTxt);

	    // get the value from 'seatsTxt' in the 'ticket' instance
	    JSpinner spinnerFromTicket = (JSpinner) field.get(ticket);
		int number = (Integer) spinnerFromTicket.getValue();
		
		assertTrue("the number should be greater than 0", number > 0);
	}

}
