
import java.io.Serializable;
import java.util.Scanner;

/**
 * One object of class Person represents the contact information for one person.
 */
public class Person implements Comparable<Person>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private String firstName;
	private String lastName;
	private String Address;
	private String email;
	private String phone;
	private String notes;

	public Person() {

	}

	public Person(String firstName, String lastName, String streetAddress, String email, String phone, String notes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.Address = streetAddress;
		this.email = email;
		this.phone = phone;
		this.notes = notes;
	}

	public void read() {
		Scanner systemInput = new Scanner(System.in);
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
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	/**
	 * Sets the value of newLastName to lastName.
	 */
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}

	/**
	 * Sets the value of newStreetAddress to StreetAddress.
	 */
	public void setAddress(String newAddress) {
		Address = newAddress;
	}

	/**
	 * Sets the value of newEmail to Email.
	 */
	public void setEmail(String newEmail) {
		email = newEmail;
	}

	/**
	 * Sets the value of newPhone to phone.
	 */
	public void setPhone(String newPhone) {
		phone = newPhone;
	}

	/**
	 * Sets the value of newNotes to notes.
	 */
	public void setNotes(String newNotes) {
		notes = newNotes;
	}

	/**
	 * Returns a string containing all the contact information for a single
	 * person.
	 */
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String toString() {
		String printString="";
		printString=firstName+" "+lastName+":\n"+"Address: "+Address+"\n"+"email: "+email+
		"\n"+"phone: "+phone+"\n"+"notes: "+notes+"\n";
		return printString;
	}

	@Override
	public int compareTo(Person o) {
		if (this.getLastName().compareToIgnoreCase(o.getLastName()) > 0) {
			return 1;
		} else if (this.getLastName().compareToIgnoreCase(o.getLastName()) < 0) {
			return -1;
		} else if (this.getFirstName().compareToIgnoreCase(o.getFirstName()) > 0) {
			return 1;
		} else if (this.getFirstName().compareToIgnoreCase(o.getFirstName()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
