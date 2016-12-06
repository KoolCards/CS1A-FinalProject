import java.io.*;
import java.awt.*;
public class TestSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r = new Rectangle (4,3);
		Rectangle s = new Rectangle  ();
	      FileOutputStream outFile;
	      ObjectOutputStream outObject;
	      try  {
	         outFile = new FileOutputStream ("data");     

	         outObject = new ObjectOutputStream(outFile);

	         outObject.writeObject(r);

	         outObject.writeObject(s);

	         outFile.close();

	         outObject.close();     

	      } catch (IOException ioe)  {

	         System.out.println ("Error writing objects to the file: "+ ioe.getMessage());

	      }

	 

	      // 2) Get rid of the old Rectangles

	      r = s = null;

	                 

	      // 3) Read the 2 Rectangle objects back in from the file            
	      FileInputStream inFile;

	      ObjectInputStream inObject;

	      try  {

	         inFile = new FileInputStream("data");     

	         inObject = new ObjectInputStream(inFile);

	         r = (Rectangle)inObject.readObject();

	         s = (Rectangle)inObject.readObject();

	         inFile.close();

	         inObject.close();     

	      } catch(IOException ioe)  {

	         System.out.println ("Error reading from the file: " + ioe.getMessage());

	      } catch (ClassNotFoundException cnfe)  {

	         System.out.println ("Error in casting to Rectangle: " + cnfe);

	      }

	      // 4) Print the 2 Rectangle objects to see if they were read in correctly

	      System.out.println (r);

	      System.out.println (s);
	}

}
