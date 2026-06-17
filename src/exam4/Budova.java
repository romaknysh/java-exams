package exam4;

import java.util.Optional;

public abstract class Budova {

    public abstract void aktualizuj(HernySvet hernySvet);

    public abstract void pridajSurovinuNaSklad(Surovina surovina);

    public abstract void vyberSurovinuZoSkladu(Surovina surovina);

    public abstract boolean jeNaPozicii(int riadok, int stlpec);

    protected abstract boolean ziskajSurovinuVOkolo(HernySvet hernySvet, Surovina surovina);

    protected abstract Optional<VyrobnyPlan> zacniProdukciu();
}
