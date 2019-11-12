
public class Arrays {
	public static void main(String[] args) {
		int[] array = new int[10];
		String output ="";
		
		for(int i = 0; i<10;i++) {
			array[i]= (int) (Math.random()*20) +1;
			output +=array[i] + "; ";
		}
		
		System.out.println(output);
		
		array = BubbleSort(array);
		output = "";
		
		for(int i = 0; i<10; i++) {
			output += array[i] + "; ";
		}
		
		System.out.println(output);
		System.out.println(sumUp(array));
	}
	
	
	public static int[] BubbleSort(int[] input) {
		boolean loop = true;
		
		while (loop) {
			loop = false;
			
			for (int i = 0; i<input.length - 1; i++) {
				
				if(input[i] > input[i+1]) {
					int temp = input[i];
					input[i] = input[i+1];
					input[i+1] = temp;
					loop = true;
				}
			}
		}
		
		return input;
	}
	
	
	public static int sumUp(int[] input) {
		
		 int result = 0;
		 for(int i = 0; i<input.length; i++) {
			 result += input[i];
		 }
		 return result;
		
	}

}
