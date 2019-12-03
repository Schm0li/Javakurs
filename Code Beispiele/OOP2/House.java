
public abstract class House {
	private int price;
	
	public House() {
		this.price = ((int)(Math.random()*100) + 1) * 10000;
	}
	
	public abstract int getPrice();

}
