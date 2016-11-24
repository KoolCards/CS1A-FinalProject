import java.util.ArrayList;
/**
  * One object of class ContactList represents the contact information for one group of people.
  */
public class ContactList {
    private ArrayList<Object> personList=new ArrayList<>();
    /**
     * Constructor that allocates space for the list.
     */
    public ContactList() {
    	
    }
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
