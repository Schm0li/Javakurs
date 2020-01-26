public class MatrixEntry {
    private double zahl;

    public MatrixEntry() {
        zahl = (int) (Math.random() * 10) + 1;
    }

    public double getZahl() {
        return zahl;
    }

    public void setZahl(double zahl) {
        this.zahl = zahl;
    }

    @Override
    public String toString(){
        return zahl + "";
    }
}
