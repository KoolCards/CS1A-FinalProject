import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
	private ContactList list[] = new ContactList [5];
	private String first_name[] = new String [5];
	private String last_name[] = new String [5];
	
	public void addPerson () {
		System.out.println("Enter the ID number");
		Scanner input = new Scanner(System.in);
		int ID = input.nextInt();
		ContactList person = new ContactList ();
		person.addFirstName(ID);
		person.addStreetAddress(ID);
		list[ID] = person;
		System.out.println(list[ID].first_name + " " + list[ID].last_name);
	}
	
	public void addFirstName (int ID) {
		System.out.println("Enter the first name");
		Scanner input = new Scanner(System.in);
		String firstName = input.next();
		first_name[ID] = firstName;
	}
	
	public void addStreetAddress (int ID) {
		System.out.println("Enter the last name");
		Scanner input = new Scanner(System.in);
		String lastname = input.next();
		last_name[ID] = lastname;
	}

		public void addperson() {

	 }
		public void print() {

	 }
		public void retrive(String lastName) {
		
	 }

		public void quitAndSave() {
		
	 }
		public void open() {
		
	 }
	
}
