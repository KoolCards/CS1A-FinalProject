import java.awt.*;
import javax.swing.*;

import java.util.*;
import java.awt.event.*;
import java.text.NumberFormat;


public class HomePageGUI extends JFrame implements ActionListener {
	JButton search;
	JButton addNew;
	JButton printContactList;
	JPanel buttonsPanel;
	JPanel thePanel;
	JList contactList;
	JScrollPane scrollPane;
	String [] data = {"Steve", "Jack", "Harry", "John", "Jim", "Quincy", "Adam", "George","Martin","King","Stan"}; 
public static void main(String[] args){		
	new HomePageGUI();		
}	
public HomePageGUI(){		
	// Define the size of the frame		
	this.setSize(400, 400);				
	// Opens the frame in the middle of the screen		
	this.setLocationRelativeTo(null);		
	// Define how the frame exits (Click the Close Button)		
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	// Define the title for the frame				
	this.setTitle("MY CONTACT LIST - The smart way to keep in touch");				
	// The JPanel contains all of the components for your frame				
	thePanel = new JPanel();	
	thePanel.setLayout(new GridBagLayout());
	
	buttonsPanel = new JPanel();
	addComp(thePanel, buttonsPanel, 0, 15, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE);
	search = new JButton("SEARCH BY LAST NAME");
	addComp(buttonsPanel, search, 0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE);
	addNew = new JButton("ADD NEW CONTACT");
	addComp(buttonsPanel, addNew, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
	printContactList = new JButton("PRINT CONTACT LIST");
	addComp(buttonsPanel, printContactList, 0, 0, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE);
	contactList = new JList(data);
	contactList.setFixedCellHeight(30);				
	contactList.setFixedCellWidth(400);
	addComp(thePanel, contactList, 0, 0, 4, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
	JScrollPane scrollPane = new JScrollPane(contactList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	thePanel.add(scrollPane);

    
    

    //getContentPane().add(scrollPane);
	
	this.add(thePanel);
	// Adjusts the size of the frame to best work for the components
	this.pack();
	this.setVisible(true);
	// Define if the user can resize the frame (true by default)
	this.setResizable(true);
	search.addActionListener(this);
	addNew.addActionListener(this);
	printContactList.addActionListener(this);
	}
	public void actionPerformed (ActionEvent e){
		if (e.getSource () == search){
			search.setText("button pressed");
            /*
             * Add code to open Search GUI
             */
    }
		else if (e.getSource() == addNew){
			addNew.setText("button pressed");
            /*
             * Add code to open add New Contact GUI
             */
				new GuiTest();
				//add to the ArrayList
    }
		else if (e.getSource() == printContactList){
			printContactList.setText("button pressed");
            /*
             * Add code to Print Contact List
             */
    }

}	
//}

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