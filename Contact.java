package module;

import java.util.ArrayList;

public class Contact {
	public static ArrayList<String> contactUIDs = new ArrayList<String>();
	public String contactId;
	public String firstName;
	public String lastName;
	public String phone;
	public String address;
	
	public Contact(String _contactId, String _firstName, String _lastName, String _phone, String _address) throws IllegalArgumentException, ArrayStoreException {
		// Change params to iterable objects based on requirements...
		
		// Not Empty Reqs:
		String[] reqNotNull = {_contactId, _firstName, _lastName, _phone, _address};
		for(String str : reqNotNull  ) {
			if(!Contact.CheckNotNull(str))
				throw new IllegalArgumentException("Param is null");
		}
		
		// Size Reqs:
		String[] reqUnderTen = {_contactId, _firstName, _lastName};
		for(String str : reqUnderTen  ) {
			if(!Contact.CheckStrLen(10,1,str))
				throw new IllegalArgumentException("Param is too long");
		}
		
		String[] reqExactlyTen = {_phone};
		for(String str : reqExactlyTen  ) {
			if(!Contact.CheckStrLen(10,10,str))
				throw new IllegalArgumentException("Param is not 10 digits");
		}
		
		String[] reqUnderThirty = {_address};
		for(String str : reqUnderThirty  ) {
			if(!Contact.CheckStrLen(30,1,str))
				throw new IllegalArgumentException("Param is too long");
		}
		
		// Datatype Reqs:
		String[] reqOnlyDigits = {_phone};
		for(String str : reqOnlyDigits  ) {
			if(!Contact.CheckIfDigits(str))
				throw new IllegalArgumentException("Param is not numbers");
		}
		
		// Uniqueness Reqs:
		if(!Contact.CheckContactIsUnique(_contactId))
			throw new ArrayStoreException("Contact ID already exists");
		
		contactUIDs.add(_contactId);
		contactId 	= _contactId;
		firstName 	= _firstName;
		lastName 	= _lastName;
		phone 		= _phone;
		address 	= _address;
	}
	
	// Validators - typically returns false if there's an issue
	private static boolean CheckContactIsUnique(String str) {
		for(String UID : Contact.contactUIDs) {
			if(str.equals(UID)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean CheckNotNull(Object obj) {
		return obj != null;
	}
	
	public static boolean CheckStrLen(int maxLen, int minLen, String str) {
		return str.length() <= maxLen & str.length() >= minLen;
	}
	
	public static boolean CheckIfDigits(String str) {
		return str.matches("^[0,1,2,3,4,5,6,7,8,9]+$");
	}
	
	
}
