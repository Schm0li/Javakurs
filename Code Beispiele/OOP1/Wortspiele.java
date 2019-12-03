import java.util.HashMap;
import java.util.Map;

public class Wortspiele {
	static Map<Integer, String> nouns = new HashMap<>();
	static Map<Integer, String> adjectifs = new HashMap<>();
	public static void main(String[] args) {
		fillMaps();
		
		for(int i = 0; i<10; i++) {
			int keyNoun = (int) (Math.random()*13);
			int keyAdj = (int) (Math.random()*13);
			System.out.println(adjectifs.get(keyAdj) + " " + nouns.get(keyNoun));
		}
	}

	public static void fillMaps() {
		nouns.put(0, "Kater");
		nouns.put(1, "Tiger");
		nouns.put(2, "Elefant");
		nouns.put(3, "Vulkan");
		nouns.put(4, "Alligator");
		nouns.put(5, "Krater");
		nouns.put(6, "Tanker");
		nouns.put(7, "Wolf");
		nouns.put(8, "Einschlag");
		nouns.put(9, "Tsunami");
		nouns.put(10, "Orkan");
		nouns.put(11, "Wal");
		nouns.put(12, "Zyklop");
		
		adjectifs.put(0, "blinder");
		adjectifs.put(1, "hungriger");
		adjectifs.put(2, "taumelnder");
		adjectifs.put(3, "schlafender");
		adjectifs.put(4, "tänzelnder");
		adjectifs.put(5, "stottender");
		adjectifs.put(6, "humpelnder");
		adjectifs.put(7, "rollender");
		adjectifs.put(8, "gähnender");
		adjectifs.put(9, "bärtiger");
		adjectifs.put(10, "hüpfender");
		adjectifs.put(11, "maskierter");
		adjectifs.put(12, "jodelnder");
	}

}
