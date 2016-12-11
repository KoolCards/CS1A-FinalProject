import java.io.*;
import java.util.*;

public class ContactList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	/**
	 * 
	 */

	private ArrayList<Person> list = new ArrayList<Person>();
	public int PeopleNumber=list.size();
	public ContactList() {}

	public void addperson(Person newperson) {
		list.add(newperson);
		Collections.sort(list);
	}
	
	public String toString() {
		String tempString = "";
		for (int i = 0; i < list.size(); i++) {
			tempString += list.get(i) + "\n";
		}
		return tempString;
	}

	public void PrintContactList() {
		System.out.println(toString());
	}

	public void clear() {
		list.clear();
	}

	public String SearchbyLast(String newlastname) {
		String personlistString = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getLastName().equals(newlastname)) {
				personlistString += list.get(i) + "\n";
			}
		}
		return personlistString;
	}

}
