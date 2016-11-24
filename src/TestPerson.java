/**
 * Tests class ContactList and Person by calling all methods in ContactList and Person
 */
public class TestPerson {
	public static void main(String args[]) {
		final String dummyText = ""; 
		ContactList contactlist1;
		contactlist1 = new ContactList();
		contactlist1.addNewPerson();
		contactlist1.printList();
		Person person1;
		person1 = new Person();
		person1.read();
		person1.setFirstName(dummyText);
		person1.setLastName(dummyText);
		person1.setAddress(dummyText);
		person1.setEmail(dummyText);
		person1.setPhone(dummyText);
		person1.setNotes(dummyText);
		System.out.println("Person #1: " + person1);
	}
}
/*
Full Contact List: 
Person #1: 
*/