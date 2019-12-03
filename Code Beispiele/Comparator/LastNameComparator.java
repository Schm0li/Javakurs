import java.util.Comparator;

public class LastNameComparator implements Comparator<Person>{
	@Override
	public int compare(Person first, Person second) {
	        return first.getLastName().compareTo(second.getLastName());
	    }
	}
