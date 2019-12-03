public class Material {
    private String name;
    private int anzahl;

    public Material(String name, int anzahl){
        this.name = name;
        this.anzahl = anzahl;
    }

    public String getName() {
        return name;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    @Override
    public String toString(){
        return "Materialname: " + name + ", Bestandsanzahl: " + anzahl;
    }
}
