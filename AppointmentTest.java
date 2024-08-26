package module_tests;

import static org.junit.Assert.assertThrows;

// JUnit4 Exception Testing
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import module.Appointment;
import java.util.Date;
import java.util.Calendar;
// JUnit5 Exception Testing (for RepeatedTest decorator)
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;


public class AppointmentTest{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	static char _nullTestNum, _maxLenTestNum = 0x00;
	
	@Test
	public void TestDuplicateID() throws ArrayStoreException {
		thrown.expect(ArrayStoreException.class);
		Appointment first_appointment = new Appointment("123",new Date(),"do something");
		Appointment second_Appointment = new Appointment("123",new Date(),"do something else");
	}
	
	@RepeatedTest(value=3)
	public void TestNotNull() throws IllegalArgumentException {
		switch(_nullTestNum++) {
			case 0x00:
				// ID is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Appointment t_appointment = new Appointment(null,new Date(),"do something");
				});
				break;
			case 0x01:
				// Date is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Appointment t_appointment = new Appointment("1234",null,"do something");
				});
				break;
			case 0x02:
				// Description is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Appointment t_appointment = new Appointment("12345",new Date(),null);
				});
				break;
		}
	}
	
	@RepeatedTest(value=2)
	public void TestMaxLen() throws IllegalArgumentException {
		switch(_maxLenTestNum++) {
			case 0x00:
				// ID is  too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Appointment t_appointment = new Appointment("12345678901",new Date(),"do something");
				});
				break;
			case 0x01:
				// Description is too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Appointment t_appointment = new Appointment("1234567",new Date(),"do something that is really long and causes the thingy to throw an exeception cuz this is too long and it's like nah bruh you sellen then yeets an exception");
				});
				break;
		}
	}
	
	@Test
	public void TestMinDate() throws IllegalArgumentException {
		// Date is in the past
		Calendar c = Calendar.getInstance();
		c.set(c.YEAR, 2000);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			Appointment t_appointment = new Appointment("1239",c.getTime(),"do something");
		});
	}

}
