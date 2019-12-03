import java.util.List;
import java.util.ArrayList;
import java.util.Observable;

public class Inventar extends Observable {
    private List<Material> materials;
    private final int grenzwert = 5;

    public Inventar(){
        materials = new ArrayList<>();
    }

    public void addMaterial(Material material){
        if(!materials.contains(material)) {
            materials.add(material);
        }
    }

    public void entnehmeMaterial(String name, int anzahl){
        Material m = null;
        for(Material material : materials){
            if(material.getName().equals(name)){
                m = material;
                break;
            }
        }
        materials.remove(m);
        if(m.getAnzahl() - anzahl < grenzwert){
            setChanged();
            notifyObservers(m);
        }
        m.setAnzahl(m.getAnzahl() - anzahl);
        materials.add(m);
    }

    public void aufstocken(Material material){
        material.setAnzahl(material.getAnzahl() + 2 * grenzwert);
    }

    public List<Material> getMaterials() {
        return materials;
    }
}
