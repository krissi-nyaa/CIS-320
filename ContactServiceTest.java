package module_tests;

import static org.junit.Assert.assertThrows;

//JUnit4 Exception Testing
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import module.Contact;
import module.ContactService;

//JUnit5 Exception Testing (for RepeatedTest decorator)
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class ContactServiceTest {
	
	@Test
	public void TestAddContact() {
		ContactService cs = new ContactService();
		Contact c = new Contact("321","krissi","yan","5104032912","8797 Huh St.; Lala-land, CA");
		cs.AddContact(c);
		
		// We should have a contact with the id 321
		assertEquals(cs.GetContact("321").contactId,"321");
	}
	
	@Test
	public void TestDeleteContact() {
		ContactService cs = new ContactService();
		Contact c = new Contact("1234","krissi","yan","5104032912","8797 Huh St.; Lala-land, CA");
		cs.AddContact(c);
		
		// We should have a contact with the id 1234
		assertEquals(cs.GetContact("1234").contactId,"1234");
		
		cs.DeleteContact("1234");
		
		// We should not have a contact with the id 1234
		assertNull(cs.GetContact("1234"));
	}
	
	@Test
	public void TestUpdateContact() {
		ContactService cs = new ContactService();
		Contact c = new Contact("12345","krissi","yan","5104032912","8797 Huh St.; Lala-land, CA");
		cs.AddContact(c);
		
		Contact other_c = cs.GetContact("12345");
		// We should have a contact with the id 12345 and other info
		assertEquals(other_c.contactId,"12345");
		assertEquals(other_c.firstName,"krissi");
		assertEquals(other_c.lastName,"yan");
		assertEquals(other_c.phone,"5104032912");
		assertEquals(other_c.address,"8797 Huh St.; Lala-land, CA");
		
		other_c.firstName = "meow";
		other_c.lastName = "woof";
		other_c.phone = "1010010010";
		other_c.address = "somewhere else now";
		
		cs.UpdateContact(other_c);
		
		// Information should now be updated
		other_c = cs.GetContact("12345");
		assertEquals(other_c.contactId,"12345");
		assertEquals(other_c.firstName,"meow");
		assertEquals(other_c.lastName,"woof");
		assertEquals(other_c.phone,"1010010010");
		assertEquals(other_c.address,"somewhere else now");
	}
}
