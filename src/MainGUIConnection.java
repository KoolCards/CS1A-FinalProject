public class MainGUIConnection {
	public static void main() {
		final String dummyText = ""; 
		ContactList contactlist1;
		contactlist1 = new ContactList();
		contactlist1.addNewPerson();
		contactlist1.addNewPerson();
		System.out.println(contactlist1.searchByLast());
        GuiTest g = new GuiTest();
    }
}