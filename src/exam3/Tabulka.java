package exam3;

import java.util.ArrayList;
import java.util.List;

public class Tabulka {
    private String[] stlpce;
    private List<Riadok> riadky;

    public Tabulka(String[] stlpce) {
        this.stlpce = stlpce;
        this.riadky = new ArrayList<>();
    }

    public Tabulka vytvorPrazdnuKopiu() {
        return new Tabulka(this.stlpce);
    }

    public void pridajRiadok(String[] hodnoty) {
        if (hodnoty.length != this.stlpce.length) throw new RuntimeException("Nespravny pocet hodnot");
        this.riadky.add(new Riadok(this, hodnoty));
    }

    public int getIndexStlpca(String stlpec) {
        for (int i = 0; i < this.stlpce.length; i++) {
            if (this.stlpce[i].equals(stlpec)) return i;
        }
        throw new RuntimeException("Stlpec nenajdeny: " + stlpec);
    }

    public Iterable<Riadok> getRiadky() {
        return this.riadky;
    }

    public String[] getStlpce() {
        return this.stlpce;
    }

    public void vypis() {
        for (String stlpec : this.stlpce) {
            System.out.printf("%10s |", stlpec);
        }
        System.out.println();
        for (Riadok riadok : this.riadky) {
            for (String stlpec : this.stlpce) {
                System.out.printf("%10s |", riadok.getHodnota(stlpec));
            }
            System.out.println();
        }
    }
}