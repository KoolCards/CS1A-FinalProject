import java.io.*;
import java.util.Scanner;
/*
 * Tests class ContactList and class Person by creating a new ContactList Object 
 * and allows the user to enter commands to manipulate the contact list.
 */
public class ConsoleMain {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("enter \"add\" to add a person" + "\n" 
				+ "enter \"save\" to save the contact list" + "\n"
				+ "enter \"searchbylast\" to search the people by last name" + "\n"
				+ "enter \"open\" to open the contact list in a file" + "\n"
				+ "enter \"print\" to print the whole contact list" + "\n"
				+ "enter \"exit\" to quit the program" + "\n");
		ContactList myContactList = new ContactList();
		boolean isActive = true;
		FileInputStream inputFile;
		ObjectInputStream inputObject;
		try {
			inputFile = new FileInputStream("data");
			inputObject = new ObjectInputStream(inputFile);
			myContactList = (ContactList) inputObject.readObject();
			inputObject.close();
			inputFile.close();					
		} 
		catch (IOException e) {
			System.out.println("Error reading object from the file" + e.getMessage());
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Error in casting to ContactList: " + e);
		}
		System.out.println("------------------------------------");
		while (isActive) {
			String comString;
			comString = console.next();
			if (comString.equalsIgnoreCase("add")) {
				Person newPerson = new Person();
				newPerson.read();
				System.out.println("------------------------------------");
				myContactList.addNewPerson(newPerson);
				continue;
			}
			else if (comString.equalsIgnoreCase("save")) {
				FileOutputStream outFile;
				ObjectOutputStream outObject;
				try {
					outFile = new FileOutputStream("data");
					outObject = new ObjectOutputStream(outFile);
					outObject.writeObject(myContactList);
					outObject.close();
					outFile.close();
				} 
				catch (IOException e) {
					System.out.println("Error writing objects to the file: " + e.getMessage());
				}
				myContactList.clear();
				System.out.println("------------------------------------");
				continue;
			} 
			else if (comString.equalsIgnoreCase("searchbylast")) {
				System.out.println("Last Name: ");
				System.out.println(myContactList.searchByLast(console.next()));
				System.out.println("------------------------------------");
				continue;
			} 
			else if (comString.equalsIgnoreCase("print")) {
				System.out.println(myContactList.toString());
				System.out.println("------------------------------------");
				continue;
			}
			else if (comString.equalsIgnoreCase("exit")) {
				FileOutputStream outFile;
				ObjectOutputStream outObject;
				try {
					outFile = new FileOutputStream("data");
					outObject = new ObjectOutputStream(outFile);
					outObject.writeObject(myContactList);
					outObject.close();
					outFile.close();
				} 
				catch (IOException e) {
					System.out.println("Error writing objects to the file: " + e.getMessage());
				}
				myContactList.clear();
				System.out.println("------------------------------------");
				isActive = false;
				continue;
			} 
			else {
				System.out.println(comString + " is not a valid command." + "\n");
				System.out.println("------------------------------------");
				continue;
			}
		}
	}
}
