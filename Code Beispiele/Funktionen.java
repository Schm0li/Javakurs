
public class Funktionen {
	public static void main(String[] args){
		int a = 4;
		int b = 2;
		
		System.out.println(powerOf(a,b));
		
		System.out.println(fibonacci(a));
		System.out.println(fibonacci(b));
		
		
	}
	
	public static int fibonacci(int input){
		int n0 = 0;
		int n1 = 1;
		
		for(int i = 0; i<input; i++){
			int temp = n1 + n0;
			n0 = n1;
			n1 = temp;	
		}
		
		return n1;
	}
	
	public static int powerOf(int base, int exponent){
		
		int result = 1;
		for(int i = 0; i < exponent ; i++){
			result *= base;
		}
		
		return result;
	}
	
	/*public static int factorial(int input){
		int result = 1;
		for (int i = 1; i <= input; i++) {
			result *=i;
		}
		
		return result;
	}*/

}
