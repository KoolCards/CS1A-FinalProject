import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

public class GuiTest extends JFrame implements ActionListener{
	private JLabel firstNameLabel, lastNameLabel, streetAddressLabel, emailAddressLabel, phoneLabel,
		notesLabel;
	private JTextField firstNameText, lastNameText,streetAddressText, emailAddressText, phoneText;
	private JTextArea notesText;
	private JButton addContact;
	private String firstName, lastName, streetAddress, phone, email, notes;
	private ContactList contactList;
	public static void main(String[] args){
		new GuiTest();
		
	}
	public GuiTest(){
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
		
		contactList = new ContactList();
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
			   	  contactList.addNewPersonFromGUI(person);//Add new person to Array
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