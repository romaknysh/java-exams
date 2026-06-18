package exam4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Budova {
    private int riadok;
    private int stlpec;
    private List<Surovina> sklad;
    protected VyrobnyPlan aktualnyPlan;
    protected HernySvet hernySvet;

    public Budova(int riadok, int stlpec) {
        this.riadok = riadok;
        this.stlpec = stlpec;
        this.sklad = new ArrayList<>();
    }

    public void pridajSurovinuNaSklad(Surovina surovina) {
        this.sklad.add(surovina);
    }

    public boolean vyberSurovinuZoSkladu(Surovina surovina) {
        return this.sklad.remove(surovina);
    }

    public boolean jeNaPozicii(int riadok, int stlpec) {
        return this.riadok == riadok && this.stlpec == stlpec;
    }

    public int getRiadok() { return this.riadok; }
    public int getStlpec() { return this.stlpec; }
    public int getSkladSize() { return this.sklad.size(); }

    public abstract void aktualizuj(HernySvet hernySvet);
    protected abstract boolean ziskajSurovinuVOkolo(HernySvet hernySvet, Surovina surovina);
    protected abstract Optional<VyrobnyPlan> zacniProdukciu();
}