package module;

import java.util.ArrayList;

public class Task {
	public static ArrayList<String> taskUIDs = new ArrayList<String>();
	public String taskId;
	public String name;
	public String description;
	
	public Task(String _taskId, String _name, String _description) throws IllegalArgumentException, ArrayStoreException {
		// Change params to iterable objects based on requirements...
		
		// Not Empty Reqs:
		String[] reqNotNull = {_taskId, _name, _description};
		for(String str : reqNotNull  ) {
			if(!Contact.CheckNotNull(str))
				throw new IllegalArgumentException("Param is null");
		}
		
		// Size Reqs:
		String[] reqUnderTen = {_taskId};
		for(String str : reqUnderTen  ) {
			if(!Contact.CheckStrLen(10,1,str))
				throw new IllegalArgumentException("Param is too long");
		}
		
		String[] reqUnderTwenty = {_name};
		for(String str : reqUnderTwenty  ) {
			if(!Contact.CheckStrLen(20,1,str))
				throw new IllegalArgumentException("Param is too long");
		}
		
		String[] reqUnderFifty = {_description};
		for(String str : reqUnderFifty  ) {
			if(!Contact.CheckStrLen(50,1,str))
				throw new IllegalArgumentException("Param is too long");
		}
		
		// Uniqueness Reqs:
		if(!Task.CheckTaskIsUnique(_taskId))
			throw new ArrayStoreException("Contact ID already exists");
		
		taskUIDs.add(_taskId);
		taskId 	= _taskId;
		name 	= _name;
		description 	= _description;
	}
	
	// Validators - typically returns false if there's an issue
	private static boolean CheckTaskIsUnique(String str) {
		for(String UID : Task.taskUIDs) {
			if(str.equals(UID)) {
				return false;
			}
		}
		return true;
	}
	
}
