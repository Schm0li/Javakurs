public class Euklid {
    public static void main(String[] args) {
        int zahl1 = (int) (Math.random() * 1000) + 1;
        int zahl2 = (int) (Math.random() * 1000) + 1;
        int zahl;
        int quotient;
        if(zahl1 < zahl2) {
            zahl = zahl2;
            quotient = zahl1;
        }else {
            zahl = zahl1;
            quotient = zahl2;
        }
        int rest = -1;
        String rechnung = "";
        while(rest != 0) {
            rest = zahl % quotient;
            rechnung += zahl + " : " + quotient + " = " + zahl / quotient + " R" + rest + "\n";
            zahl = quotient;
            quotient = rest;
        }
        System.out.println(rechnung);
        System.out.println("ggT(" + zahl1 + ", " + zahl2 + ") = " + zahl);
    }
}
