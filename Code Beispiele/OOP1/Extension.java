
public class Extension {
	public static void main(String[] args) {
		Animal animal1 = new Animal("1");
		Animal animal2 = new Animal("2");
		Cat animal3 = new Cat("mittens");
		Dog animal4 = new Dog("pupper");	
		
		animal1.sound();
		animal3.sound();
		animal2.sound();
		animal4.sound();
		
		
	}

}
