import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Wunschlisten {

    public int preis(HashMap<String, Integer> input){
        int out = 0;
        for(String key : input.keySet()){
         out += input.get(key);
        }

        return out;
    }

    @Test
    public void kostenListe1(){
        HashMap<String, Integer> liste1 = new HashMap<>();
        liste1.put("Harry Potter und der Duden", 20);
        liste1.put("Call of Duty - Battles of the present Past-Future",50);
        liste1.put("iPhone LXIX", 2000);                                                                         //bis jetzt 24
        liste1.put("Die Bud Spencer und Terrence Hill - Collection", 25);

        assertTrue("Kosten bitte im nachvollziehbaren bereich halten",preis(liste1)<100);
    }

    @Test
    public void kostenListe2(){
        HashMap<String, Integer> liste2 = new HashMap<>();
        liste2.put("Gesammelte Werke von H.P.Lovecraft", 20);
        liste2.put("Stephen King - ES",10);
        liste2.put("Bud Spencer und Terrence Hill - Collection", 25);
        liste2.put("Sony On-Ear Kopfhoerer, schwarz",50);

        assertTrue("Kosten bitte im nachvollziehbaren bereich halten", preis(liste2)<100);
    }
}
