import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class TestContactlist {
	public static void main(String[] args) {
		Person me = new Person();
		me.setFirstName("liwei");
		me.setLastName("lu");
		Person he = new Person();
		he.setLastName("lu");
		he.setFirstName("ricardo");
		Person me1 = new Person();
		me1.setFirstName("asdfa");
		me1.setLastName("lu");
		Person he1 = new Person();
		he1.setLastName("Smith");
		he1.setFirstName("lu");
		ContactList myContactList = new ContactList();
		myContactList.addperson(me);
		myContactList.addperson(he);
		myContactList.addperson(he1);
		myContactList.addperson(me1);
		myContactList.PrintContactList();
	}
}
