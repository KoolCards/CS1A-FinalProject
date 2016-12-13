import java.io.Serializable;
import java.util.*;
/**
  * One object of class ContactList represents the contact information for one group of people.
  */
public class ContactList implements Serializable{
    private ArrayList<Person> personList=new ArrayList<>();
	private static final long serialVersionUID = 1L;
    /**
     * Receives a person object paramaeter and adds it to a list of people. This method also
     * sorts the people by last name or first name if the last names or the same.
     */
	public void addNewPerson(Person newperson) {
		personList.add(newperson);
		Collections.sort(personList);
	}
    /**
     * Searches for the Person object by the specified last name and returns the contact information for that person. 
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
     * Prints the entire contact list to the console.
     */
	public void clear() {
		personList.clear();
	}
    public void printList() {
    	for (int counter = 0; counter < personList.size(); counter++) {
    		System.out.println(personList.get(counter));
    	}
    }
    public String toString() {
    	String contact = "";
    	for (int counter = 0; counter < personList.size(); counter++) {
    		contact += personList.get(counter) + "\n";
    	}
    	return contact;
    }
}
