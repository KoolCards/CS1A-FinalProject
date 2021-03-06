import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.*;
/**
  * One object of class ContactList represents the contact information for one group of people.
  */
public class ContactList implements Serializable{
    private ArrayList<Person> personList=new ArrayList<Person>();
	private static final long serialVersionUID = 1L;
    /**
     * Receives a person object parameter and adds it to a list of people. This method also
     * sorts the people by last name or first name if the last names or the same.
     * K.R.
     */
	public void addNewPerson(Person newperson) {
		personList.add(newperson);
		Collections.sort(personList);
	}
    /**
     * Searches for the Person object by the specified last name and returns the contact information for that person.
     * R.L.
     */
	public String searchByLast(String lastName) {
		String retrieveContactList = "";
		for (int counter = 0; counter < personList.size(); counter++) {
			Person temPerson = (Person) personList.get(counter);
			String temLastName = temPerson.getLastName();
			if (temLastName.equalsIgnoreCase(lastName)) {
				retrieveContactList += temPerson + "\n";
			}
		}
		if (retrieveContactList.equals("")) {
			retrieveContactList = "There is no user with the specified last name";
		}
		return retrieveContactList;
	}
    /**
     * Clears the current contact list
     * K.S.
     */
	public void clear() {
		personList.clear();
	}
     /**
     * Prints the contact list to the console
     * K.S.
     */
    public void printList() {
    	for (int counter = 0; counter < personList.size(); counter++) {
    		System.out.println(personList.get(counter));
    	}
    }
    /**
     * Returns a string with each contact in the contact list
     * R.L.
     */
    public String toString() {
    	String contact = "";
    	for (int counter = 0; counter < personList.size(); counter++) {
    		contact += personList.get(counter) + "\n";
    	}
    	return contact;
    }
}
