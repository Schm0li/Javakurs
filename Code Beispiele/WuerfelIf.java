public class WuerfelIf{
	public static void main(String[] args) {
		//Simulation eines sechsseitigen Würfels
		
		for(int i=0; i< 100; i++) {
		int augenzahl = (int) (Math.random() * 6) + 1;
		
		if(augenzahl == 1) {
			System.out.println("1");
		}
		
		if(augenzahl == 2) {
			System.out.println("2");
		}
		
		if(augenzahl == 3) {
			System.out.println("3");
		}
		
		if(augenzahl == 4) {
			System.out.println("4");
		}
		
		if(augenzahl == 5) {
			System.out.println("5");
		}
		
		if(augenzahl == 6) {
			System.out.println("6");
		}
		}
	}
}