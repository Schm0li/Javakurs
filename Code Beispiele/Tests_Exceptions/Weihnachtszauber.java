import java.util.ArrayList;

public class Weihnachtszauber {
    public static void main(String[] args) throws Rauswurf{
        Elfe hansi = new Elfe("Hansi","Ich liebe das 20-Stunden-Schichstsystem");
        Elfe klausi = new Elfe("Klausi","Ich wünschte, ich könnte noch mehr arbeiten");
        Elfe karli = new Elfe("Karli", "Ich glaube, wir bräcuhten eine Gewerkschaft");
        Elfe rudi = new Elfe("Rudi", "Ich hoffe, ich darf heute die Rentiere striegeln");

        ArrayList<Elfe> arbeitsTruppAlpha19Delta = new ArrayList<>();

        arbeitsTruppAlpha19Delta.add(hansi);
        arbeitsTruppAlpha19Delta.add(klausi);
        arbeitsTruppAlpha19Delta.add(karli);
        arbeitsTruppAlpha19Delta.add(rudi);

        for(Elfe e : arbeitsTruppAlpha19Delta){
            if(e.getGedanken().contains("Gewerkschaft")){
                throw new Rauswurf("Santa mag keine Unruhestifter, " + e.getName()+"!");
            }
        }

    }

}
