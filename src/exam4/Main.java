package exam4;

public class Main {
    public static void main(String[] args) {
        HernySvet svet = new HernySvet();
        svet.pridajBudovu(new VrtnaSuprava(1, 1, Surovina.ZELEZNA_RUDA));
        svet.pridajBudovu(new VrtnaSuprava(4, 2, Surovina.MEDENA_RUDA));
        svet.pridajBudovu(new Pec(1, 2));
        svet.pridajBudovu(new Pec(3, 2));
        svet.pridajBudovu(new Tovaren(2, 2));
        svet.pridajBudovu(new Tovaren(3, 1));

        for (int i = 1; i <= 20; i++) {
            System.out.println("Herny krok " + i + ":");
            svet.vykonajKrok();
        }
    }
}