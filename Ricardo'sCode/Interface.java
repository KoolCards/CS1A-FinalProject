import java.awt.Button;
import java.io.*;
import javax.swing.*;

public class Interface {
	private ContactList myContactList;

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setSize(300, 480);
		jFrame.setTitle("Contact List");
		JPanel jPanel = new JPanel();
		jFrame.add(jPanel);
		jFrame.setVisible(true);
		Button addpeople = new Button("Add new contact");
		jPanel.add(addpeople);
	}

	public void Save() {
		FileOutputStream outFile;
		ObjectOutputStream outObject;
		try {
			outFile = new FileOutputStream("data");
			outObject = new ObjectOutputStream(outFile);
			outObject.writeObject(myContactList);
			outFile.close();
			outObject.close();
		} catch (IOException e) {
			System.out.println("Error writing objects to the file: " + e.getMessage());
		}
		 myContactList=null;
	}

	public void Open() {
		FileInputStream inputFile;
		ObjectInputStream inputObject;
		try {
			inputFile = new FileInputStream("data");
			inputObject = new ObjectInputStream(inputFile);
			myContactList = (ContactList) inputObject.readObject();
			inputFile.close();
			inputObject.close();
		} catch (IOException e) {
			System.out.println("Error reading object from the file" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error in casting to Rectangle: " + e);
		}
	}
}
