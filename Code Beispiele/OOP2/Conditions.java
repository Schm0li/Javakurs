
public class Conditions {
	public static void main(String[] args) {
		AppertmentBlock block = new AppertmentBlock();
		Villa mansion = new Villa();
		WoodShack shack = new WoodShack();
		
		block.conditions();
		mansion.conditions();
		shack.conditions();
		
		System.out.println(mansion.getPrice());
	}

}
