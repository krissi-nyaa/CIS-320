package module;

import java.util.ArrayList;

public class ContactService {
	private ArrayList<Contact> contacts;
	
	public ContactService() {
		 contacts = new ArrayList<Contact>();
	}
	
	public Contact GetContact(String _contactId) {
		for( Contact contact : contacts ) {
			if(contact.contactId.equals(_contactId))
				return contact;
		}
		return null;
	}
	
	// This is unsupported :3
	public void AddContact(String _contactId, String _firstName, String _lastName, String _phone, String _address) {
		contacts.add(new Contact(_contactId, _firstName, _lastName, _phone, _address));
	}
	
	public void AddContact(Contact c) {
		contacts.add(c);
	}
	
	public void DeleteContact(String _contactId) {
		Contact toDelete = null;
		for( Contact contact : contacts ) {
			if(contact.contactId.equals(_contactId)) {
				toDelete = contact;
				break;
			}
		}
		contacts.remove(toDelete);
	}
	
	public void UpdateContact(Contact c) {
		for( Contact contact : contacts ) {
			if(contact.contactId.equals(c.contactId))
			{
				// Probably a better way to do this but i'm sleepy ~_~
				contacts.get(contacts.indexOf(contact)).firstName = c.firstName;
				contacts.get(contacts.indexOf(contact)).lastName = c.lastName;
				contacts.get(contacts.indexOf(contact)).phone = c.phone;
				contacts.get(contacts.indexOf(contact)).address = c.address;
			}
		}
	}
}
