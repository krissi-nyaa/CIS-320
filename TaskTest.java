package module_tests;

import static org.junit.Assert.assertThrows;

// JUnit4 Exception Testing
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import module.Task;

// JUnit5 Exception Testing (for RepeatedTest decorator)
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;


public class TaskTest{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	static char _nullTestNum, _maxLenTestNum = 0x00;
	
	@Test
	public void TestDuplicateID() throws ArrayStoreException {
		thrown.expect(ArrayStoreException.class);
		Task first_task = new Task("123","some task","do something");
		Task second_Task = new Task("123","some other task","do something else");
	}
	
	@RepeatedTest(value=3)
	public void TestNotNull() throws IllegalArgumentException {
		switch(_nullTestNum++) {
			case 0x00:
				// ID is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Task t_task = new Task(null,"some task","do something");
				});
				break;
			case 0x01:
				// Name is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Task t_task = new Task("1234",null,"do something");
				});
				break;
			case 0x02:
				// Description is null
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Task t_task = new Task("12345","some task",null);
				});
				break;
		}
	}
	
	@RepeatedTest(value=3)
	public void TestMaxLen() throws IllegalArgumentException {
		switch(_maxLenTestNum++) {
			case 0x00:
				// ID is  too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Task t_task = new Task("12345678901","some task","do something");
				});
				break;
			case 0x01:
				// Name is too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Task t_task = new Task("123456","really super long task name lols","do something");
				});
				break;
			case 0x02:
				// Description is too long
				Assertions.assertThrows(IllegalArgumentException.class, ()-> {
					Task t_task = new Task("1234567","some task","do something that is really long and causes the thingy to throw an exeception cuz this is too long and it's like nah bruh you sellen then yeets an exception");
				});
				break;
		}
	}

}
