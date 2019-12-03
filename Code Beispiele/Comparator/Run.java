import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {
	public static void main(String[] args) {
		Person p1 = new Person("Robert","Witterel");
		Person p2 = new Person("William","Hoscut");
		Person p3 = new Person("Martin","Perrott");
		Person p4 = new Person("John","Davies");
		Person p5 = new Person("Alfred","Klestil");
		Person p6 = new Person("Charles","Miner");
		Person p7 = new Person("Henry","Evans");
		Person p8 = new Person("James","Wallace");
		Person p9 = new Person("Winston","Smith");
		Person p10 = new Person("Marcus","Gibbs");
		
		List<Person> persons = new ArrayList<>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(p5);
		persons.add(p6);
		persons.add(p7);
		persons.add(p8);
		persons.add(p9);
		persons.add(p10);
		
		Collections.sort(persons);
		System.out.println(persons);
		
	}

}
