import java.util.Scanner;
/**
 * One object of class Person represents the contact information for one person.
 */
public class Person {
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String email;
	private String phone;
	private String notes;
	/**
	 * Reads the console for user input for the first name, last name, street address, email, phone, and notes.
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
	 */
	public void setFirstName (String newFirstName) {
		firstName = newFirstName;
	}
	/**
	 * Sets the value of newLastName to lastName.
	 */
	public void setLastName (String newLastName) {
		lastName = newLastName;
	}
	/**
	 * Returns the value of the last name.
	 */
	public String getLastName () {
		return lastName;
	}
	/** 
	 * Sets the value of newStreetAddress to StreetAddress.
	 */
	public void setAddress (String newStreetAddress) {
		streetAddress = newStreetAddress;
	}
	/**
	 * Sets the value of newEmail to Email.
	 */
	public void setEmail (String newEmail) {
		email = newEmail;
	}
	/**
	 * Sets the value of newPhone to phone.
	 */
	public void setPhone (String newPhone) {
		phone = newPhone;
	}
	/**
	 * Sets the value of newNotes to notes.
	 */
	public void setNotes (String newNotes) {
		notes = newNotes;
	}
	/**
	 * Returns a string containing all the contact information for a single person.
	 */
	public String toString() {
		String personInfo = firstName + " " + lastName + " " + streetAddress + " " + " " + email + " " + " " + phone
				+ " " + notes;
		return personInfo;
	}
}
