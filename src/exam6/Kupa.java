package exam6;

public class Kupa extends Policko {
    public Kupa(int cisloPolicka) {
        super(cisloPolicka);
    }

    @Override
    public int vykonaj(Autosalon okruh, int financieHraca) {
        System.out.println("Policko cislo " + getCisloPolicka());

        if (financieHraca < 10000) {
            System.out.println("Aka skoda, nemas dost penazi na kupu.");
            return financieHraca;
        }

        int pocet = okruh.getPocetPolicok();
        Jazda najdenaJazda = null;
        int indexJazdy = -1;

        for (int krok = 1; krok <= pocet; krok++) {
            int i = (this.getCisloPolicka() - krok + pocet) % pocet;
            if (okruh.getPolicko(i) instanceof Jazda jazda) {
                najdenaJazda = jazda;
                indexJazdy = i;
                break;
            }
        }

        if (najdenaJazda == null) {
            System.out.println("Bohuzial ziadne vozidlo nie je k dispozicii na kupu.");
            return financieHraca;
        }

        System.out.println("Vyhodne si si kupil ojazdene vozidlo znacky " + najdenaJazda.getZnackaVozidla());

        okruh.nastavPolicko(indexJazdy, new Policko(indexJazdy));
        okruh.nastavPolicko(this.getCisloPolicka(), new Policko(this.getCisloPolicka()));

        return financieHraca - 10000;
    }
}