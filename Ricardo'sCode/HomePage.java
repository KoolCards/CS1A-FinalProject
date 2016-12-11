import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
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

public class HomePage extends JFrame implements ActionListener{
	private static final long serialVersionUID = 3636549296071613133L;
	private static ContactList myContactList= new ContactList();
	private static final Point DEFUALT_OPEN_LOCATION=new Point(300, 180);
	private static void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch){
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
	public void Hide() {
		setVisible(false);
	}
	public void Show() {
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		JButton clickedbutton = (JButton) e.getSource();
		if (clickedbutton.getText() == "Add a new Contact") {
			new AddContact();
		} else if (clickedbutton.getText() == "Print the Contact List") {
			new Print();
		} else if (clickedbutton.getText() == "Search by lastname") {
			new Search();
		}
	}
	public HomePage() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				save();
			}
			public void windowOpened(WindowEvent e) {
				open();
			}
		});

		JPanel homepageJPanel = new JPanel();
		JButton addButton, printButton, searchButton;
		addButton = new JButton("Add a new Contact");
		printButton = new JButton("Print the Contact List");
		searchButton = new JButton("Search by lastname");
		addButton.addActionListener(this);
		printButton.addActionListener(this);
		searchButton.addActionListener(this);
		homepageJPanel.add(addButton);
		homepageJPanel.add(printButton);
		homepageJPanel.add(searchButton);
		add(homepageJPanel);
		setSize(300, 200);
		setLocation(300, 180);
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
	private JTextField firstNameText, lastNameText,streetAddressText, emailAddressText, phoneText,notesText;
	private JButton addContact;
	private String firstName, lastName, streetAddress, phone, email, notes;
	public AddContact (){
		// Create the frame, position it and handle closing it
		this.setLocation(DEFUALT_OPEN_LOCATION);
		this.setTitle("Add New Contact");
		setSize(300, 485);
		JPanel thePanel = new JPanel();
		thePanel.setLayout(new GridBagLayout());
		
		firstNameLabel = new JLabel("First Name");
		addComp(thePanel, firstNameLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		firstNameText = new JTextField(30);
		addComp(thePanel, firstNameText, 0, 2, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		lastNameLabel = new JLabel("Last Name");
		addComp(thePanel, lastNameLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		lastNameText = new JTextField(30);
		addComp(thePanel, lastNameText, 0, 4, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		streetAddressLabel = new JLabel("Street Address");
		addComp(thePanel, streetAddressLabel, 0, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		streetAddressText = new JTextField(30);
		addComp(thePanel, streetAddressText, 0, 6, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		emailAddressLabel = new JLabel("Email Address (ie: you@example.com)");
		addComp(thePanel, emailAddressLabel, 0, 7, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		emailAddressText = new JTextField(30);
		addComp(thePanel, emailAddressText, 0, 8, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		phoneLabel = new JLabel("Phone Number (XXX-XXX-XXXX)");
		addComp(thePanel, phoneLabel, 0, 9, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		phoneText = new JTextField(30);
		addComp(thePanel, phoneText, 0, 10, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		notesLabel = new JLabel("Notes");
		addComp(thePanel, notesLabel, 0, 11, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
		notesText = new JTextField(30);
		addComp(thePanel, notesText, 0, 12, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addContact = new JButton("Add New Contact");
		addComp(thePanel, addContact, 0, 13, 1, 1, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE);
		addContact.addActionListener(this);	
		this.add(thePanel);
		// Adjusts the size of the frame to best work for the components
		this.pack();
		this.setVisible(true);
		// Define if the user can resize the frame (true by default)
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				Hide();
			}
			public void windowClosing(WindowEvent e) {
				Show();
			}
		});
   	}

   	public void actionPerformed (ActionEvent e){
   		
   		if (e.getSource () == addContact){
              addNewContact();
        }
   		}	
	// Sets the rules for a component destined for a GridBagLayout
	// and then adds it 
	
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
		 String emailFormat="\\w+@\\w+\\.com";

		 System.out.println(phone);
		   	if(lastName.equals("")){
		   		JOptionPane.showMessageDialog(null, "Please enter last name.");
		   	} else if (! email.matches(emailFormat)&&!(email.equals(""))) {
				JOptionPane.showMessageDialog(null, "Please enter correct email");
			} else if (!isPhone(phone)&&!(phone.equals(""))) {
				JOptionPane.showMessageDialog(null, "Please enter correct phone number");
			}
		   	else{
		   		if (!phone.equals("")) {
		   			StringBuilder stringBuilder=new StringBuilder(phone);
					 stringBuilder.insert(3, "-");
					 stringBuilder.insert(7, "-");
					 phone=stringBuilder.toString();
				}
			   	  //create a Person object and pass it to ArrayList to save it
			   	  Person person = new Person(firstName, lastName, streetAddress, email, phone, notes);
			   	  myContactList.addperson(person);//Add new person to Array
			   	  JOptionPane.showMessageDialog(null, person.toString());
		      }
		 clear();
	     }
	 public boolean isPhone(String phone) {
		 int flag=0;
		 char[] phoneCharArray=phone.toCharArray();
		 for (int i = 0; i < phoneCharArray.length; i++) {
			if (!Character.isDigit(phoneCharArray[i])) {
				flag=1;
			}
		}
		if (phone.length()==10) {
			if (flag==0) {
				return true;
			} else return false;	
		} else return false;

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
		private TextArea printTextArea;
		private JPanel jPanel;
		public  Print() {
			printTextArea=new TextArea(29,35);
			jPanel=new JPanel();
			setSize(300, 485);
			setLocation(DEFUALT_OPEN_LOCATION);
			setVisible(true);
			jPanel.setSize(getSize());
			printTextArea.setSize(getSize());
			printTextArea.setEditable(false);
			printTextArea.setSize(getSize());
			printTextArea.setText(myContactList.toString());
			jPanel.add(printTextArea);
			add(jPanel);
			this.addWindowListener(new WindowAdapter() {
				public void windowOpened(WindowEvent e) {
					Hide();
				}
				public void windowClosing(WindowEvent e) {
					Show();
				}
			});
		}
	}
	class Search extends JFrame implements ActionListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4880328478428515838L;
		private JTextField lastNameField;
		private JButton searchJButton;
		private TextArea listTextArea;
		public  Search() {
			this.setLayout(new BorderLayout());
			lastNameField=new JTextField(10);
			searchJButton=new JButton("Search");
			listTextArea=new TextArea(25,25);
			setSize(300,485);
			setVisible(true);
			setLocation(300,180);
			JPanel upJPanel=new JPanel(new FlowLayout(2));
			JPanel downJPanel=new JPanel();
			upJPanel.setSize(300, 20);
			upJPanel.add(lastNameField);
			upJPanel.add(searchJButton);
			downJPanel.add(listTextArea);
			searchJButton.addActionListener(this);
			this.add(upJPanel,BorderLayout.NORTH);
			this.add(downJPanel,BorderLayout.SOUTH);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			listTextArea.setText(myContactList.SearchbyLast(lastNameField.getText()));
		}
	}

}