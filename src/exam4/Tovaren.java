package exam4;

import java.util.Optional;

public class Tovaren extends Budova{
    public Tovaren(int riadok, int stlpec){
        super(riadok, stlpec);
    }

    @Override
    public void aktualizuj(HernySvet hernySvet) {

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
