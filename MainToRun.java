import java.io.*;
import java.util.Scanner;

public class MainToRun {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("input \"add\" to add a person" + "\n" + "input \"save\" to save the contact list" + "\n"
				+ "input \"searchbylast\" to search the people by last name" + "\n"
				+ "input \"open\" to open the contact list in a file" + "\n"
				+ "input \"print\" to print the whole contact list" + "\n");
		ContactList myContactList = new ContactList();
		while (true) {
			String comString;
			comString = console.next();
			if (comString.equals("add")) {
				Person newPerson = new Person();
				newPerson.read();
				System.out.println("------------------------------------");
				myContactList.addperson(newPerson);
				continue;
				
			} else if (comString.equals("save")) {
				FileOutputStream outFile;
				ObjectOutputStream outObject;
				try {
					outFile = new FileOutputStream("data");
					outObject = new ObjectOutputStream(outFile);
					outObject.writeObject(myContactList);
					outObject.close();
					outFile.close();
				} catch (IOException e) {
					System.out.println("Error writing objects to the file: " + e.getMessage());
				}
				myContactList.clear();
				System.out.println("------------------------------------");
				continue;
				
			} else if (comString.equals("open")) {
					FileInputStream inputFile;
					ObjectInputStream inputObject;
					try {
						inputFile = new FileInputStream("data");
						inputObject = new ObjectInputStream(inputFile);
						myContactList = (ContactList) inputObject.readObject();
						inputObject.close();
						inputFile.close();					
					} catch (IOException e) {
						System.out.println("Error reading object from the file" + e.getMessage());
					} catch (ClassNotFoundException e) {
						System.out.println("Error in casting to Rectangle: " + e);
					}
				System.out.println("------------------------------------");
				continue;
				
			} else if (comString.equals("searchbylast")) {
				System.out.println("Last Name: ");
				System.out.println(myContactList.SearchbyLast(console.next()));
				System.out.println("------------------------------------");
				continue;
				
			} else if (comString.equals("print")) {
				myContactList.PrintContactList();
				System.out.println("------------------------------------");
				continue;
				
			} else {
				System.out.println(comString + " is not a valid command." + "\n");
				System.out.println("------------------------------------");
				continue;
			}
		}
	}
}
