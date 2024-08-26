package module_tests;

import static org.junit.Assert.assertThrows;

// JUnit4 Exception Testing
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import module.Contact;

// JUnit5 Exception Testing (for RepeatedTest decorator)
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;


public class ContactTest{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	static char _nullTestNum, _maxLenTestNum = 0x00;
	// Tests for Contact class:
	// Contact(String _contactId, String _firstName, String _lastName, String _phone, String _address)
	
	@Test
	public void TestDuplicateID() throws ArrayStoreException {
		// Playing around... wanted to try this method of exception testing as well :)
		thrown.expect(ArrayStoreException.class);
		Contact first_contact = new Contact("123","krissi","yan","5105024106","8797 Huh St.; Lala-land, CA");
		Contact second_contact = new Contact("123","zelda","prince","5104038021","9797 Huh St.; Lala-land, CA");
	}
	
	@RepeatedTest(value=5)
	public void TestNotNull() throws IllegalArgumentException {
		switch(_nullTestNum++) {
			case 0x00:
				// ID is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact(null,"krissi","yan","5105024106","8797 Huh St.; Lala-land, CA");
				});
				break;
			case 0x01:
				// First name is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact("123",null,"yan","5105024106","8797 Huh St.; Lala-land, CA");
				});
				break;
			case 0x02:
				// Last name is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact("123","krissi",null,"5105024106","8797 Huh St.; Lala-land, CA");
				});
				break;
			case 0x03:
				// Phone number is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact("123","krissi","yan",null,"8797 Huh St.; Lala-land, CA");
				});
				break;
			case 0x04:
				// Address is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact("123","krissi","yan","5105024106",null);
				});
				break;
		}
	}
	
	@Test
	public void TestMinLen() {
		// Phone number is too short
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			Contact t_contact = new Contact("123","krissi","yan","510","8797 Huh St.; Lala-land, CA");
		});
	}
	
	@RepeatedTest(value=5)
	public void TestMaxLen() throws IllegalArgumentException {
		switch(_maxLenTestNum++) {
			case 0x00:
				// ID is  too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact("12345678901","krissi","yan","5105024106","8797 Huh St.; Lala-land, CA");
				});
				break;
			case 0x01:
				// First name is too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact("123","xX69420krissi360noscopeXx","yan","5105024106","8797 Huh St.; Lala-land, CA");
				});
				break;
			case 0x02:
				// Last name is too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact("123","krissi","xX69420yan360noscopeXx","5105024106","8797 Huh St.; Lala-land, CA");
				});
				break;
			case 0x03:
				// Phone number is too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact("123","krissi","yan","5105024106123123","8797 Huh St.; Lala-land, CA");
				});
				break;
			case 0x04:
				// Address is too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Contact t_contact = new Contact("123","krissi","yan","5105024106123123","8797 Huh St.; Lala-land, CA i am really loooooooong");
				});
				break;
		}
	}
	
	@Test
	public void TestDatatype() throws IllegalArgumentException {
		// Phone number is not a number
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			Contact t_contact = new Contact("123","krissi","yan","fiveoneoho","8797 Huh St.; Lala-land, CA");
		});
	}

}
