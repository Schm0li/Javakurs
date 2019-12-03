import java.util.Observable;
import java.util.Observer;

public class InventarObserver implements Observer {
    private Inventar inventar;

    @Override
    public void update(Observable o, Object arg) {
        Material material = (Material) arg;
        inventar = (Inventar) o;
        inventar.aufstocken(material);
    }
}
