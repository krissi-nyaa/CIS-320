package module_tests;

import static org.junit.Assert.assertThrows;

//JUnit4 Exception Testing
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import module.Task;
import module.TaskService;

//JUnit5 Exception Testing (for RepeatedTest decorator)
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class TaskServiceTest {
	
	@Test
	public void TestAddTask() {
		TaskService cs = new TaskService();
		Task c = new Task("321","some task","do something");
		cs.AddTask(c);
		
		// We should have a task with the id 321
		assertEquals(cs.GetTask("321").taskId,"321");
	}
	
	@Test
	public void TestDeleteTask() {
		TaskService cs = new TaskService();
		Task c = new Task("4321","some task","do something");
		cs.AddTask(c);
		
		// We should have a task with the id 1234
		assertEquals(cs.GetTask("4321").taskId,"4321");
		
		cs.DeleteTask("4321");
		
		// We should not have a task with the id 1234
		assertNull(cs.GetTask("4321"));
	}
	
	@Test
	public void TestUpdateTask() {
		TaskService cs = new TaskService();
		Task c = new Task("54321","some task","do something");
		cs.AddTask(c);
		
		Task other_c = cs.GetTask("54321");
		// We should have a task with the id 12345 and other info
		assertEquals(other_c.taskId,"54321");
		assertEquals(other_c.name,"some task");
		assertEquals(other_c.description,"do something");
		
		other_c.name = "meow";
		other_c.description = "woof";
		
		cs.UpdateTask(other_c);
		
		// Information should now be updated
		other_c = cs.GetTask("54321");
		assertEquals(other_c.taskId,"54321");
		assertEquals(other_c.name,"meow");
		assertEquals(other_c.description,"woof");
		
		// NOTE: You inherently cannot update the taskId because the UpdateTask function
		//	takes a full task object as an argument - e.g. you will get a 'not found' error
		//	if trying to update the taskId which is covered in the TaskTest class
	}
}
