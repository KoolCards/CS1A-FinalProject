import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;

public class GuiTest extends JFrame{
	JLabel firstNameLabel, lastNameLabel, streetAddressLabel, emailAddressLabel, phoneLabel,
		notesLabel;
	JTextField firstNameText, lastNameText,streetAddressText, emailAddressText, phoneText,
		notesText;
	JTextArea notes;
	public static void main(String[] args){
		new GuiTest();
	}
	public GuiTest(){
		// Create the frame, position it and handle closing it
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		notes = new JTextArea(8, 30);
		notes.setText("Additional notes");
		notes.setLineWrap(true);
		notes.setWrapStyleWord(true);
		addComp(thePanel, notes, 0, 5, 4, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		this.add(thePanel);
		// Adjusts the size of the frame to best work for the components
		this.pack();
		this.setVisible(true);
		// Define if the user can resize the frame (true by default)
		this.setResizable(false);	
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

}