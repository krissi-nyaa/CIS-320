package module_tests;

import static org.junit.Assert.assertThrows;

//JUnit4 Exception Testing
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import module.Appointment;
import module.AppointmentService;
import java.util.Date;
import java.util.Calendar;

//JUnit5 Exception Testing (for RepeatedTest decorator)
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class AppointmentServiceTest {
	
	@Test
	public void TestAddAppointment() {
		Calendar c = Calendar.getInstance();
		c.set(c.YEAR, c.get(c.YEAR) + 2);
		AppointmentService cs = new AppointmentService();
		Appointment a = new Appointment("321",c.getTime(),"do something");
		cs.AddAppointment(a);
		
		// We should have a appointment with the id 321
		assertEquals(cs.GetAppointment("321").appointmentId,"321");
	}
	
	@Test
	public void TestDeleteAppointment() {
		Calendar c = Calendar.getInstance();
		c.set(c.YEAR, c.get(c.YEAR) + 2);
		AppointmentService cs = new AppointmentService();
		Appointment a = new Appointment("4321",c.getTime(),"do something");
		cs.AddAppointment(a);
		
		// We should have a appointment with the id 1234
		assertEquals(cs.GetAppointment("4321").appointmentId,"4321");
		
		cs.DeleteAppointment("4321");
		
		// We should not have a appointment with the id 1234
		assertNull(cs.GetAppointment("4321"));
	}
	
	@Test
	public void TestUpdateAppointment() {
		Calendar c = Calendar.getInstance();
		c.set(c.YEAR, c.get(c.YEAR) + 2);
		Calendar oc = Calendar.getInstance();
		oc.set(oc.YEAR, oc.get(oc.YEAR) + 2);
		AppointmentService cs = new AppointmentService();
		Appointment a = new Appointment("54321",c.getTime(),"do something");
		cs.AddAppointment(a);
		
		Appointment other_c = cs.GetAppointment("54321");
		// We should have a appointment with the id 12345 and other info
		assertEquals(other_c.appointmentId,"54321");
		assertEquals(other_c.date,oc.getTime());
		assertEquals(other_c.description,"do something");
		
		other_c.date = oc.getTime();
		other_c.description = "woof";
		
		cs.UpdateAppointment(other_c);
		
		// Information should now be updated
		other_c = cs.GetAppointment("54321");
		assertEquals(other_c.appointmentId,"54321");
		assertEquals(other_c.date,oc.getTime());
		assertEquals(other_c.description,"woof");
		
		// NOTE: You inherently cannot update the appointmentId because the UpdateAppointment function
		//	takes a full appointment object as an argument - e.g. you will get a 'not found' error
		//	if trying to update the appointmentId which is covered in the AppointmentTest class
	}
}
