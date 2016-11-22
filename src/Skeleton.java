
public class Skeleton {
	 class Main {
		 public static void main(String args[]) {
			 Person p1;
		     p1 = new Person();
		     p1.read();
		     System.out.println("Person #1: " + e1);
		     Person p2;
		     p2 = new Person();
		     p2.read();
		     System.out.println("Person #2: " + e2);
		    }
		}
		/**
		  * One object of this class represents one Name,
		  * including first, middle and last.
		  */
	 class Name {
		 private String first;
		 private String last;
		 public Name(){};
		
		 public void read(){};
		 public String toString(){};
		}
		 
		/**
		  * One object of this class represents info about one Employee,
		  *   including name and social security number .
		  */
class Person {
	private Name name;
	private String ssn;
	public Person(){};
	public void read(){};
	public String toString(){};
		}

class ContactList {
    private Person list[];
    /**
     * Constructor that allocates space for the list.
     */
    public ContactList() {}
    /**
     * Creates a new Employee object and adds it to the list, if there is room.
     */
    public void addNewContact()  {}
    /**
     * Returns a String containing all the data in the list.
     */
}
