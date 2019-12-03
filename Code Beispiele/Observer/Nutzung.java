public class Nutzung {
    public static void main(String[] args){
        Material material1 = new Material("Bambus", 20);
        Material material2 = new Material("Solarit", 7);
        Inventar inventar = new Inventar();
        inventar.addMaterial(material1);
        inventar.addMaterial(material2);
        InventarObserver observer = new InventarObserver();
        inventar.addObserver(observer);
        inventar.entnehmeMaterial(material1.getName(), 14);
        inventar.entnehmeMaterial(material2.getName(), 3);
        for(Material m : inventar.getMaterials()){
            System.out.println(m);
        }
    }
}
