import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;

/*
 * Creates a new HomePage with multiple classes to act as a contact list program for a user.
 */
public class HomePage extends JFrame implements ActionListener {
	private static final long serialVersionUID = 3636549296071613133L;
	private static ContactList myContactList = new ContactList();
	private static final Point DEFUALT_OPEN_LOCATION = new Point(300, 180);
	/*
	 * Creates a template for adding new GUI components.
	 * K.R.
	 */
	private static void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight,
			int place, int stretch) {
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = xPos;
		gridConstraints.gridy = yPos;
		gridConstraints.gridwidth = compWidth;
		gridConstraints.gridheight = compHeight;
		gridConstraints.weightx = 100;
		gridConstraints.weighty = 100;
		gridConstraints.insets = new Insets(5, 5, 5, 5);
		gridConstraints.anchor = place;
		gridConstraints.fill = stretch;
		thePanel.add(comp, gridConstraints);
	}
	/*
	 * Saves the current contact list to the data file.
	 * K.S.
	 */
	public void save() {
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
	}
	/*
	 * Opens the contact list from the data file.
	 * R.L.
	 */
	public void open() {
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
			System.out.println("Error in casting to Rectangle: " + e);
		}
	}
	/*
	 * Makes window disappear
	 * R.L.
	 */
	public void noDisp() {
		setVisible(false);
	}
	/*
	 * Makes window reappear
	 * R.L.
	 */
	public void disp() {
		setVisible(true);
	}
	/*
	 * Sets up each button to run the desired method
	 * K.R.
	 */
	public void actionPerformed(ActionEvent e) {
		JButton clickedbutton = (JButton) e.getSource();
		if (clickedbutton.getText() == "Add a new Contact") {
			new AddContact();
		} 
		else if (clickedbutton.getText() == "Print the Contact List") {
			new Print();
		} 
		else if (clickedbutton.getText() == "Search by lastname") {
			new Search();
		} 
		else if (clickedbutton.getText() == "Clear the contactlist") {
			myContactList.clear();
		}
	}
	/*
	* Default constructor for the HomePage class that sets dimensions for HomePage window
	* R.L.
	*/
	public HomePage() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				save();
			}

			public void windowOpened(WindowEvent e) {
				open();
			}
		});
		setTitle("MY CONTACT LIST");
		setResizable(false);
		JPanel homepageJPanel = new JPanel();
		JButton addButton, printButton, searchButton, clearButton;
		addButton = new JButton("Add a new Contact");
		printButton = new JButton("Print the Contact List");
		searchButton = new JButton("Search by Last Name");
		clearButton = new JButton("Clear the Contact List");
		addButton.addActionListener(this);
		printButton.addActionListener(this);
		searchButton.addActionListener(this);
		clearButton.addActionListener(this);
		homepageJPanel.add(addButton);
		homepageJPanel.add(printButton);
		homepageJPanel.add(searchButton);
		homepageJPanel.add(clearButton);
		add(homepageJPanel);
		setSize(300, 200);
		setLocation(300, 180);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	/*
	 * One object of AddContact creates a new AddContact window that allows the user to input data 
	 * for a new person in the contact list.
	 * K.R.
	 */
	class AddContact extends JFrame implements ActionListener {
		private static final long serialVersionUID = -623826465110124110L;
		private JLabel firstNameLabel, lastNameLabel, streetAddressLabel, emailAddressLabel, phoneLabel, notesLabel;
		private JTextField firstNameText, lastNameText, streetAddressText, emailAddressText, phoneText, notesText;
		private JButton addContact;
		private String firstName, lastName, streetAddress, phone, email, notes;
		/*
		 * Default constructor for the AddContact class that opens a new window for the
		 * add contact page.
		 * K.R.
		 */
		public AddContact() {
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

			phoneLabel = new JLabel("Phone Number (XXXXXXXXXX)");
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
			this.pack();
			this.setVisible(true);
			this.setResizable(false);
			this.addWindowListener(new WindowAdapter() {
				public void windowOpened(WindowEvent e) {
					noDisp();
				}

				public void windowClosing(WindowEvent e) {
					disp();
				}
			});
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == addContact) {
				addNewContact();
			}
		}
		/*
		 * Creates a new person object and adds it to Contact List
		 * R.L.
		 */
		public void addNewContact() {
			firstName = firstNameText.getText();
			firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
			lastName = lastNameText.getText();
			lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
			streetAddress = streetAddressText.getText();
			phone = phoneText.getText();
			email = emailAddressText.getText();
			notes = notesText.getText();
			String emailFormat = ".*()*.+@\\w+\\.com";
			System.out.println(phone);
			if (lastName.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter last name.");
			} 
			else if (!email.matches(emailFormat) && !(email.equals(""))) {
				JOptionPane.showMessageDialog(null, "Please enter correct email");
			} 
			else if (!isPhone(phone) && !(phone.equals(""))) {
				JOptionPane.showMessageDialog(null, "Please enter correct phone number");
			} 
			else if (firstName.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter first name.");
			} 
			else {
				if (!phone.equals("")) {
					StringBuilder stringBuilder = new StringBuilder(phone);
					stringBuilder.insert(3, "-");
					stringBuilder.insert(7, "-");
					phone = stringBuilder.toString();
				}
				Person person = new Person(firstName, lastName, streetAddress, email, phone, notes);
				myContactList.addNewPerson(person);
				JOptionPane.showMessageDialog(null, person.toString());
				clear();
			}
		}

		public boolean isPhone(String phone) {
			int flag = 0;
			char[] phoneCharArray = phone.toCharArray();
			for (int i = 0; i < phoneCharArray.length; i++) {
				if (!Character.isDigit(phoneCharArray[i])) {
					flag = 1;
				}
			}
			if (phone.length() == 10) {
				if (flag == 0) {
					return true;
				} 
				else
					return false;
			} 
			else
				return false;
		}
		/*
		 * Clears all the fields in the AddContact class.
		 * K.R.
		 */
		public void clear() {
			firstNameText.setText("");
			lastNameText.setText("");
			streetAddressText.setText("");
			phoneText.setText("");
			emailAddressText.setText("");
			notesText.setText("");
		}
	}
	/*
	 * One object of class Print creates a new Print page that prints the entire contact list
	 * to the window.
	 * K.S.
	 */
	class Print extends JFrame {
		private TextArea printTextArea;
		private JPanel jPanel;
		/*
		 * Default constructor for the Print class that sets dimensions for Print window
		 * K.S.
		 */
		public Print() {
			setTitle("Contact List");
			printTextArea = new TextArea(29, 35);
			jPanel = new JPanel();
			setSize(300, 485);
			setLocation(DEFUALT_OPEN_LOCATION);
			setVisible(true);
			setResizable(false);
			jPanel.setSize(getSize());
			printTextArea.setSize(getSize());
			printTextArea.setEditable(false);
			printTextArea.setSize(getSize());
			printTextArea.setText(myContactList.toString());
			jPanel.add(printTextArea);
			add(jPanel);
			this.addWindowListener(new WindowAdapter() {
				public void windowOpened(WindowEvent e) {
					noDisp();
				}

				public void windowClosing(WindowEvent e) {
					disp();
				}
			});
		}
	}
	/*
	 * One object of Search creates a new Search window that allows the user to input data 
	 * for a last name to search for in the contact list.
	 * K.S.
	 */
	class Search extends JFrame implements ActionListener {
		private static final long serialVersionUID = -4880328478428515838L;
		private JTextField lastNameField;
		private JButton searchJButton;
		private TextArea listTextArea;
		private JPanel upJPanel;
		private JPanel downJPanel;
		/*
		 * Default constructor for the Search class that sets dimensions for Search window
		 * R.L
		 */
		public Search() {
			this.addWindowListener(new WindowAdapter() {
				public void windowOpened(WindowEvent e) {
					noDisp();
				}

				public void windowClosing(WindowEvent e) {
					disp();
				}
			});
			setTitle("Search");
			this.setLayout(new BorderLayout());
			lastNameField = new JTextField(10);
			searchJButton = new JButton("Search");
			listTextArea = new TextArea(25, 35);
			setSize(300, 485);
			setVisible(true);
			setLocation(DEFUALT_OPEN_LOCATION);
			upJPanel = new JPanel(new FlowLayout(2));
			downJPanel = new JPanel();
			upJPanel.setSize(300, 20);
			upJPanel.add(lastNameField);
			upJPanel.add(searchJButton);
			downJPanel.add(listTextArea);
			searchJButton.addActionListener(this);
			this.add(upJPanel, BorderLayout.NORTH);
			this.add(downJPanel, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (myContactList.searchByLast(lastNameField.getText()).equals("")) {
				JOptionPane.showMessageDialog(downJPanel, "No contact matched!");
			} 
			else {
				listTextArea.setText(myContactList.searchByLast(lastNameField.getText()));
			}
		}
	}
}
