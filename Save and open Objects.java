Private ContactList myContactList;
/*
Store the object "myContactList" in file
*/
	public void Save() {
		FileOutputStream outFile;
		ObjectOutputStream outObject;
		try {
			outFile = new FileOutputStream("data");
			outObject = new ObjectOutputStream(outFile);
			outObject.writeObject(myContactList);
			outFile.close();
			outObject.close();
		} catch (IOException ioe) {
			System.out.println("Error writing objects to the file: " + ioe.getMessage());
		}
		 myContactList=null;
	}
/*
Read the object "myContactList" back in from the file
*/
	public void Open() {
		FileInputStream inputFile;
		ObjectInputStream inputObject;
		try {
			inputFile = new FileInputStream("data");
			inputObject = new ObjectInputStream(inputFile);
			myContactList = (ContactList) inputObject.readObject();
			inputFile.close();
			inputObject.close();
		} catch (IOException e) {
			System.out.println("Error reading object from the file" + e.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error in casting to Rectangle: " + cnfe);
		}
	}
}
