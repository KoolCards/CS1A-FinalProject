import java.util.Comparator;
/**
 * One object of class NameComparator
 */
public class NameComparator implements Comparator<Person> {
	@Override
	/**
	 * Compares the two Person object parameters to return whether the object is greater alphabetically by last name
	 * or by first name if the last names are the same.
	 */
	public int compare(Person person1, Person person2) {
		String person1LastName = person1.getLastName();
		String person2LastName = person2.getLastName();
		String person1FirstName = person1.getFirstName();
		String person2FirstName = person2.getFirstName();
 
		if (person1LastName.compareToIgnoreCase(person2LastName) > 0) {
			return 1;
		} 
		else if (person1LastName.compareToIgnoreCase(person2LastName) < 0) {
			return -1;
		} 
		else {
			if (person1FirstName.compareToIgnoreCase(person2FirstName) > 0) {
				return 1;
			}
			else if (person1FirstName.compareToIgnoreCase(person2FirstName) < 0) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}