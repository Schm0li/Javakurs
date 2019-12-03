import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prozess{
	public static void main(String[] args) {
		Set<Bot> bots = new HashSet<>();
		List<String> products = new ArrayList<>();
		
		for (int i = 0; i<10;i++) {
			int id = (int) (Math.random()*800) + 101;
			int modif = (int) (Math.random()*5) + 1;
			bots.add(new Bot(id, modif));
			
			int a = i+1;
			products.add(i, "Product" + a );
		}
		
		int index = 0;
		for (Bot bot : bots) {
			System.out.println("Bot " + bot.getID());
			for (int i = 0; i < bot.getModifier(); i++) {
				System.out.println(products.get(index));
			}
			index++;
			System.out.println("");
		}
	}

}
