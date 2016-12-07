/**
 * Tests Use Case 1 by initializing a ContactList object, adding two Person objects to the list and
 * calls the printList() method after each add in order to illustrate that those Person objects were 
 * added to the ContactList object
 */
public class Main {
	public static void main (String [] args) {
		ContactList contactlist1;
		contactlist1 = new ContactList();
		contactlist1.addNewPerson();
		contactlist1.printList();
		contactlist1.addNewPerson();
		contactlist1.printList();
	}
}
/*
Enter the first name.
Kevin
Enter the last name.
Rapp
Enter the street address.
1312 California Street
Enter the email address.
kevin.rapp@gmail.com
Enter the phone number.
321-867-5309
Enter the notes.
Likes walks in the park
Kevin	Rapp	1312 California Street	kevin.rapp@gmail.com	321-867-5309	Likes walks in the park
Enter the first name.
Stevie
Enter the last name.
Wonder
Enter the street address.
123 Piano Way
Enter the email address.
OhIWonder@hotmail.com
Enter the phone number.
None
Enter the notes.
Very superstitious
Kevin	Rapp	1312 California Street	kevin.rapp@gmail.com	321-867-5309	Likes walks in the park
Stevie	Wonder	123 Piano Way	OhIWonder@hotmail.com	None	Very superstitious
*/
