package exam4;

import java.util.Optional;

public class Tovaren extends Budova{
    public Tovaren(int riadok, int stlpec){

    }

    @Override
    public void aktualizuj(HernySvet hernySvet) {

    }

    @Override
    public void pridajSurovinuNaSklad(Surovina surovina) {

    }

    @Override
    public void vyberSurovinuZoSkladu(Surovina surovina) {

    }

    @Override
    public boolean jeNaPozicii(int riadok, int stlpec) {
        return false;
    }

    @Override
    protected boolean ziskajSurovinuVOkolo(HernySvet hernySvet, Surovina surovina) {
        return false;
    }

    @Override
    protected Optional<VyrobnyPlan> zacniProdukciu() {
        return Optional.empty();
    }
}
