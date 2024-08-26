package module;

import java.util.ArrayList;
import java.util.Date;

public class Appointment {
	public static ArrayList<String> appointmentUIDs = new ArrayList<String>();
	public String appointmentId;
	public Date date;
	public String description;
	
	public Appointment(String _appointmentId, Date _date, String _description) throws IllegalArgumentException, ArrayStoreException {

		// Not Empty Reqs:
		Object[] reqNotNull = {_appointmentId, _date, _description};
		for(Object obj : reqNotNull  ) {
			if(!Contact.CheckNotNull(obj))
				throw new IllegalArgumentException("Param is null");
		}
		
		// Size Reqs:
		String[] reqUnderTen = {_appointmentId};
		for(String str : reqUnderTen  ) {
			if(!Contact.CheckStrLen(10,1,str))
				throw new IllegalArgumentException("Param is too long");
		}
		
		String[] reqUnderFifty = {_description};
		for(String str : reqUnderFifty  ) {
			if(!Contact.CheckStrLen(50,1,str))
				throw new IllegalArgumentException("Param is too long");
		}
		
		// Time Reqs:
		Date[] reqInFuture = { _date };
		for(Date dt : reqInFuture ) {
			if(dt.before(new Date()))
				throw new IllegalArgumentException("Date is in the past");
		}
		
		// Uniqueness Reqs:
		if(!Appointment.CheckAppointmentIsUnique(_appointmentId))
			throw new ArrayStoreException("Contact ID already exists");
		
		appointmentUIDs.add(_appointmentId);
		appointmentId 	= _appointmentId;
		date 	= _date;
		description 	= _description;
	}
	
	// Validators - typically returns false if there's an issue
	private static boolean CheckAppointmentIsUnique(String str) {
		for(String UID : Appointment.appointmentUIDs) {
			if(str.equals(UID)) {
				return false;
			}
		}
		return true;
	}
	
}
