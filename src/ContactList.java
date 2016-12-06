import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
/**
  * One object of class ContactList represents the contact information for one group of people.
  */
public class ContactList implements Serializable{
    private ArrayList<Person> personList=new ArrayList<>();
	private static final long serialVersionUID = 1L;
    /**
     * Creates a new Person object and adds it to the list 
     * but does not allow for the addition to the list if the last name is left blank.
     * This method calls the read method in the Person object to receive input from the console
     * for the Person object.
     */
    public void addNewPerson() {
    	Person newPerson = new Person();
    	personList.add(newPerson);
    	newPerson.read();
    	int currentIndex = personList.size() - 1;
    	Person newPerson2 = personList.get(currentIndex);
    	if (newPerson2.getLastName().equals("")) {
    		personList.remove(currentIndex);
    	}
    	Collections.sort(personList, new NameComparator());
    }
    /**
     * Searches for the Person object by the specified last name and returns the contact information for that person. 
     */
	public String searchByLast() {
		Scanner systemInput = new Scanner (System.in);
		System.out.println("Enter the last name to search for in the database");
		String lastName = systemInput.nextLine();
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
    public void printList() {
    	for (int counter = 0; counter < personList.size(); counter++) {
    		System.out.println(personList.get(counter));
    	}
    }
}
