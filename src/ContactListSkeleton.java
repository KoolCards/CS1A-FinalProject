import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
  * One object of class ContactListSkeleton represents the contact information for one group of people.
  */
public class ContactListSkeleton {
    private ArrayList<Person> personList=new ArrayList<>();
    /**
     * Creates a new Person object and adds it to the list 
     * but does not allow for the addition to the list if the last name is left blank.
     * This method calls the read method in the Person object to receive input from the console
     * for the Person object.
     */
    public void addNewPerson() {
    }
    /**
     * Searches for the Person object by the specified last name and returns the contact information string for that person. 
     */
	public String searchByLast() {
		String retrieveContact = "";
		return retrieveContact;
	}
    /**
     * Prints the entire contact list to the console.
     */
    public void printList() {
    }
    /**
	 * Stores the ContactList object into a file on disk.
	*/
	public void save() {
	}
	/**
	 * Reads the ContactList object from the stored file and stores it into the contact list.
	 */
	public void open() {
	}
}
