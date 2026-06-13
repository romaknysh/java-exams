package exam2;

import java.util.ArrayList;
import java.util.List;

public class CiselnyVyraz {
    private List<CastVyrazu> casti;

    private CiselnyVyraz(List<CastVyrazu> casti) {
        this.casti = casti;
    }

    public static CiselnyVyraz vytvorZRetazca(String vyrazyVTexte) {
        String[] tokeny = vyrazyVTexte.trim().split(" ");
        if (tokeny.length % 2 == 0) throw new RuntimeException("Ciselny vyraz nie je zapisany spravne.");
        List<CastVyrazu> casti = new ArrayList<>();
        for (int i = 0; i < tokeny.length; i++) {
            if (i % 2 == 0) {
                try {
                    double hodnota = Double.parseDouble(tokeny[i]);
                    casti.add(new Cislo(hodnota));
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Ciselny vyraz nie je zapisany spravne.");
                }
            } else {
                if (tokeny[i].length() != 1) throw new RuntimeException("Ciselny vyraz nie je zapisany spravne.");
                char op = tokeny[i].charAt(0);
                if (op != '+' && op != '-' && op != '*' && op != '/') {
                    throw new RuntimeException("Ciselny vyraz nie je zapisany spravne.");
                }
                casti.add(new Operacia(op));
            }
        }
        return new CiselnyVyraz(casti);
    }

    public void vyries(VyberacOperacie vyberac) {
        Vypocet vypocet = new Vypocet(this.casti, vyberac);
        System.out.println("Zadany ciselny vyraz: " + vypocet.getVyrazString());
        int krok = 1;
        while (vypocet.vykonajKrok()) {
            System.out.println("Krok " + krok + ": " + vypocet.getVyrazString());
            krok++;
        }
    }
}