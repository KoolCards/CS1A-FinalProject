import java.io.Serializable;
import java.util.Scanner;
/**
 * One object of class Person represents the contact information for one person.
 */
public class Person implements Comparable<Person>, Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String email;
	private String phone;
	private String notes;
	/**
	 * Constructor for person object that with no parameters.
	 */
	public Person () {	
	}
	/**
	 * Constructor for person object that uses String parameters.
	 */
	public Person (String firstName, String lastName, String streetAddress, String email, String phone, String notes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.email = email;
		this.phone = phone;
		this.notes = notes;
	}
	/**
	 * Reads the console for user input for the first name, last name, street address, email, phone, and notes.
	 * K.S.
	 */
	public void read() {
		Scanner systemInput = new Scanner (System.in);
		System.out.println("Enter the first name.");
		setFirstName(systemInput.nextLine());
		System.out.println("Enter the last name.");
		setLastName(systemInput.nextLine());
		System.out.println("Enter the street address.");
		setAddress(systemInput.nextLine());
		System.out.println("Enter the email address.");
		setEmail(systemInput.nextLine());
		System.out.println("Enter the phone number.");
		setPhone(systemInput.nextLine());
		System.out.println("Enter the notes.");
		setNotes(systemInput.nextLine());
	}
	/**
	 * Sets the value of newFirstName to firstName.
	 * K.S.
	 */
	public void setFirstName (String newFirstName) {
		firstName = newFirstName;
	}
	/**
	 * Returns the value of the first name.
	 * K.S.
	 */
	public String getFirstName () {
		return firstName;
	}
	/**
	 * Sets the value of newLastName to lastName.
	 * K.S.
	 */
	public void setLastName (String newLastName) {
		lastName = newLastName;	
	}
	/**
	 * Returns the value of the last name.
	 * K.S.
	 */
	public String getLastName () {
		return lastName;
	}
	/** 
	 * Sets the value of newStreetAddress to StreetAddress.
	 * K.S.
	 */
	public void setAddress (String newStreetAddress) {
		streetAddress = newStreetAddress;
	}
	/**
	 * Sets the value of newEmail to Email.
	 * K.S.
	 */
	public void setEmail (String newEmail) {
		email = newEmail;
	}
	/**
	 * Sets the value of newPhone to phone.
	 * K.S.
	 */
	public void setPhone (String newPhone) {
		phone = newPhone;
	}
	/**
	 * Sets the value of newNotes to notes.
	 * K.S.
	 */
	public void setNotes (String newNotes) {
		notes = newNotes;
	}
	/**
	 * Returns a string containing all the contact information for a single person.
	 * K.S.
	 */
	public String toString() {
		String printString="";
		printString="First Name: "+firstName+"\n"+"Last Name: "+lastName+"\n"+"Address: "+streetAddress+"\n"+"Email: "+email+
		"\n"+"Phone: "+phone+"\n"+"Notes: "+notes+"\n";
		return printString;
	}
	/**
	 * Compares two person objects to return the objects in alphabetical order by last name or
	 * by first name if the last names are the same.
	 */
	@Override
	public int compareTo(Person person1) {
		if (this.getLastName().compareToIgnoreCase(person1.getLastName()) > 0) {
			return 1;
		} 
		else if (this.getLastName().compareToIgnoreCase(person1.getLastName()) < 0) {
			return -1;
		} 
		else if (this.getFirstName().compareToIgnoreCase(person1.getFirstName()) > 0) {
			return 1;
		} 
		else if (this.getFirstName().compareToIgnoreCase(person1.getFirstName()) < 0) {
			return -1;
		} 
		else {
			return 0;
		}
	}
}
