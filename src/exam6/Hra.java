package exam6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Hra {
    private String nazovSuboru;
    private Autosalon okruh;
    private int polickoHraca;
    private int financieHraca;

    public Hra(String nazovSuboru) {
        this.nazovSuboru = nazovSuboru;
        this.polickoHraca = 0;
        this.financieHraca = 20000;

        try (DataInputStream in = new DataInputStream(new FileInputStream(nazovSuboru))) {
            int pocetPolicok = in.readInt();
            int pocetSpecialnych = in.readInt();

            this.okruh = new Autosalon(pocetPolicok);

            for (int i = 0; i < okruh.getPocetPolicok(); i++) {
                okruh.nastavPolicko(i, new Policko(i));
            }

            for (int i = 0; i < pocetSpecialnych; i++) {
                String typ = in.readUTF();
                switch (typ) {
                    case "Jazda" -> {
                        int cislo = in.readInt();
                        int cena = in.readInt();
                        String znacka = in.readUTF();
                        okruh.nastavPolicko(cislo, new Jazda(cislo, cena, znacka));
                    }
                    case "Kupa" -> {
                        int cislo = in.readInt();
                        okruh.nastavPolicko(cislo, new Kupa(cislo));
                    }
                    case "Vyhra" -> {
                        int cislo = in.readInt();
                        okruh.nastavPolicko(cislo, new Vyhra(cislo));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void vypisHry() {
        System.out.println("Hrac ma aktualne " + this.financieHraca + " penazi.");
        okruh.vypis(this.polickoHraca);
    }

    public void posunHraca(int oKolkoPolicok) {
        this.polickoHraca = (this.polickoHraca + oKolkoPolicok) % okruh.getPocetPolicok();
        Policko aktualne = okruh.getPolicko(this.polickoHraca);
        this.financieHraca = aktualne.vykonaj(this.okruh, this.financieHraca);
    }
}