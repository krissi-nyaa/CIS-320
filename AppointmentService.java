package module;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	private ArrayList<Appointment> appointments;
	
	public AppointmentService() {
		 appointments = new ArrayList<Appointment>();
	}
	
	public Appointment GetAppointment(String _appointmentId) {
		for( Appointment appointment : appointments ) {
			if(appointment.appointmentId.equals(_appointmentId))
				return appointment;
		}
		return null;
	}
	
	public void AddAppointment(String _appointmentId, Date _date, String _description) {
		appointments.add(new Appointment(_appointmentId, _date, _description));
	}
	
	public void AddAppointment(Appointment c) {
		appointments.add(c);
	}
	
	public void DeleteAppointment(String _appointmentId) {
		Appointment toDelete = null;
		for( Appointment appointment : appointments ) {
			if(appointment.appointmentId.equals(_appointmentId)) {
				toDelete = appointment;
				break;
			}
		}
		appointments.remove(toDelete);
	}
	
	// Not required... but not 'not' required :)?
	public void UpdateAppointment(Appointment c) {
		for( Appointment appointment : appointments ) {
			if(appointment.appointmentId.equals(c.appointmentId))
			{
				appointments.get(appointments.indexOf(appointment)).date = c.date;
				appointments.get(appointments.indexOf(appointment)).description = c.description;
			}
		}
	}
}
