import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller implements ActionListener {

     private ContactList model;

     private GuiTest view;
     public Controller() {
          view = new GuiTest(this);
          model = new ContactList();
     }
     /**
      * Instantiates itself to get its own constructor going.
      */
     public static void main(String args[]) {
          Controller ctr = new Controller();
     }

	public void actionPerformed(ActionEvent e) {
		model.addNewPerson();
		view.show(model.toString());
	}
}