public class VerzweigungEinfuehrung {
	public static void main(String[] args) {
		int a=10;
		int b=1;
		
		if (true) {
			System.out.println(" Das wird immer ausgeführt ");
		} else {
			System.out.println(" Das wird eigentlich nicht ausgeführt ");
		}
		
		if (a==10) {
			System.out.println(" == ist für das Betrachten auf Gleichheit");
		}
		
		if (b<a) {
			System.out.println(" < und > können auch verwendet werden");
		}
		
		if (true || false) {
			System.out.println(" && ist das logische 'und' || ist das logische 'oder' ");
		}
	}

}