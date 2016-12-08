import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

public class HomePage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3636549296071613133L;
	private static ContactList myContactList;

	public static void main(String[] args) {
		
		new HomePage();
	}
	public void save() {
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
	}
	public void open() {
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
	}
	public HomePage() {
		myContactList=new ContactList();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				save();
			}
			public void windowOpened(WindowEvent e) {
				open();
			}
		});
		class HomeButtonHandler implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton clickedbutton = (JButton) e.getSource();
				if (clickedbutton.getText() == "Add a new Contact") {
					new AddContact();
				} else if (clickedbutton.getText() == "Print the Contact List") {
					new Print();
				} else if (clickedbutton.getText() == "Search by lastname") {

				}

			}

		}
		JPanel homepageJPanel = new JPanel();
		JButton addButton, printButton, searchButton;
		HomeButtonHandler homeButtonHandler = new HomeButtonHandler();
		addButton = new JButton("Add a new Contact");
		printButton = new JButton("Print the Contact List");
		searchButton = new JButton("Search by lastname");
		addButton.addActionListener(homeButtonHandler);
		printButton.addActionListener(homeButtonHandler);
		searchButton.addActionListener(homeButtonHandler);
		homepageJPanel.add(addButton);
		homepageJPanel.add(printButton);
		homepageJPanel.add(searchButton);
		add(homepageJPanel);
		setSize(300, 200);
		setLocation(500, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class AddContact extends JFrame implements ActionListener{
		/**
		 * Open a window to add a new Contact
		 */
		private static final long serialVersionUID = -623826465110124110L;
		private JLabel firstNameLabel, lastNameLabel, streetAddressLabel, emailAddressLabel, phoneLabel,
		notesLabel;
	private JTextField firstNameText, lastNameText,streetAddressText, emailAddressText, phoneText;
	private JTextArea notesText;
	private JButton addContact;
	private String firstName, lastName, streetAddress, phone, email, notes;
	public AddContact(){
		// Create the frame, position it and handle closing it
		this.setLocationRelativeTo(null);
		this.setTitle("Add New Contact");
		
		JPanel thePanel = new JPanel();
		thePanel.setLayout(new GridBagLayout());
		
		firstNameLabel = new JLabel("First Name");
		addComp(thePanel, firstNameLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		firstNameText = new JTextField(30);
		addComp(thePanel, firstNameText, 1, 0, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		lastNameLabel = new JLabel("Last Name");
		addComp(thePanel, lastNameLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		lastNameText = new JTextField(30);
		addComp(thePanel, lastNameText, 1, 1, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		streetAddressLabel = new JLabel("Street Address");
		addComp(thePanel, streetAddressLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		streetAddressText = new JTextField(30);
		addComp(thePanel, streetAddressText, 1, 2, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		emailAddressLabel = new JLabel("Email Address (ie: you@example.com)");
		addComp(thePanel, emailAddressLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		emailAddressText = new JTextField(30);
		addComp(thePanel, emailAddressText, 1, 3, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		phoneLabel = new JLabel("Phone Number (XXX-XXX-XXXX)");
		addComp(thePanel, phoneLabel, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		phoneText = new JTextField(30);
		addComp(thePanel, phoneText, 1, 4, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		notesLabel = new JLabel("Notes");
		addComp(thePanel, notesLabel, 0, 5, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
		notesText = new JTextArea(8, 30);
		notesText.setLineWrap(true);
		notesText.setWrapStyleWord(true);
		addComp(thePanel, notesText, 0, 5, 4, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addContact = new JButton("Add New Contact");
		addComp(thePanel, addContact, 2, 20, 1, 1, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE);
		addContact.addActionListener(this);	
		
		this.add(thePanel);
		// Adjusts the size of the frame to best work for the components
		this.pack();
		this.setVisible(true);
		// Define if the user can resize the frame (true by default)
		this.setResizable(false);	
   	}

   	public void actionPerformed (ActionEvent e){
   		
   		if (e.getSource () == addContact){
              addNewContact();
        }
   		}	
	// Sets the rules for a component destined for a GridBagLayout
	// and then adds it 
	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch){
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = xPos;
		gridConstraints.gridy = yPos;
		gridConstraints.gridwidth = compWidth;
		gridConstraints.gridheight = compHeight;
		gridConstraints.weightx = 100;
		gridConstraints.weighty = 100;
		gridConstraints.insets = new Insets(5,5,5,5);
		gridConstraints.anchor = place;
		gridConstraints.fill = stretch;
		thePanel.add(comp, gridConstraints);
	}
	/*
	 * Creates a new person object and adds it to Contact List
	 */
	 public void addNewContact(){  
		 firstName = firstNameText.getText();
		 lastName= lastNameText.getText();
		 streetAddress= streetAddressText.getText();
		 phone= phoneText.getText();
		 email= emailAddressText.getText();
		 notes= notesText.getText();
		   	if(lastName.equals("")){
		   		JOptionPane.showMessageDialog(null, "Please enter last name.");
		   	}else{
			   	  //create a Person object and pass it to ArrayList to save it
			   	  Person person = new Person(firstName,lastName, streetAddress, phone, email,notes);
			   	  myContactList.addperson(person);//Add new person to Array
			   	  JOptionPane.showMessageDialog(null, person.toString());
		      }
		 clear();
	     }
	 public void clear(){
		 firstNameText.setText("");
		 lastNameText.setText("");
		 streetAddressText.setText("");
		 phoneText.setText("");
		 emailAddressText.setText("");
		 notesText.setText("");  	
		}
	}
	class Print extends JFrame{
		public  Print() {
			setSize(600, 400);
			setVisible(true);
			setLocation(500,500);
			JPanel jPanel=new JPanel();
			jPanel.setSize(this.getSize());
			TextArea textArea=new TextArea(myContactList.PeopleNumber, 6);
			textArea.setSize(500, 400);
			textArea.setName("Information");
			textArea.setText(myContactList.toString());
			
			jPanel.add(textArea);
			add(jPanel);
			
		}
	}
}