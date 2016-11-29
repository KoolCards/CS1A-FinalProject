/**
 * Tests class ContactListSkeleton and PersonSkeleton by calling all methods in ContactListSkeleton and PersonSkeleton
 */
public class TestPersonSkeleton {
	public static void main(String args[]) {
		final String dummyText = ""; 
		ContactListSkeleton contactlist1;
		contactlist1 = new ContactListSkeleton();
		contactlist1.addNewPerson();
		contactlist1.addNewPerson();
		contactlist1.addNewPerson();
		contactlist1.printList();
		System.out.println(contactlist1.searchByLast());
		PersonSkeleton person1;
		person1 = new PersonSkeleton();
		person1.read();
		person1.setFirstName(dummyText);
		person1.setLastName(dummyText);
		person1.setAddress(dummyText);
		person1.setEmail(dummyText);
		person1.setPhone(dummyText);
		person1.setNotes(dummyText);
		System.out.println("Person #1: " + person1);
		System.out.println(person1.getFirstName() + " " + person1.getLastName());
	}
}
/*
Full Contact List: 
Person #1: 

*/