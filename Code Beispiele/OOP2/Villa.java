
public class Villa extends House implements Building {
	private int price;
	
	public Villa() {
		this.price = ((int)(Math.random()*100) + 1) * 100000;
	}
	
	public void conditions() {
		System.out.println("Unnecessary and Expensive");
	}

	public int getPrice() {
		return price;
	}
}
