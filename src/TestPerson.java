import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Tests class ContactList and Person by calling all methods in ContactList and
 * Person
 */
public class TestPerson {
	public static void main(String args[]) {
		ContactList contactlist1 = new ContactList();
		contactlist1 = new ContactList();
		contactlist1.addNewPerson();
		contactlist1.addNewPerson();
		System.out.println(contactlist1.searchByLast());
		FileOutputStream outFile;
		ObjectOutputStream outObject;
		try {
			outFile = new FileOutputStream("data");
			outObject = new ObjectOutputStream(outFile);
			outObject.writeObject(contactlist1);
			outFile.close();
			outObject.close();
		} 
		catch (IOException ioe) {
			System.out.println("Error writing objects to the file: " + ioe.getMessage());
		}
		contactlist1 = null;
		FileInputStream inFile;
		ObjectInputStream inObject;
		try {
			inFile = new FileInputStream("data");
			inObject = new ObjectInputStream(inFile);
			contactlist1 = (ContactList) inObject.readObject();
			inFile.close();
			inObject.close();
		} 
		catch (IOException ioe) {
			System.out.println("Error reading from the file: " + ioe.getMessage());
		} 
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error in casting to Rectangle: " + cnfe);
		}
		contactlist1.printList();
	}
}
/*
 * Full Contact List: Person #1:
 */