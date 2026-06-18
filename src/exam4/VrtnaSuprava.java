package exam4;

import java.util.Optional;

public class VrtnaSuprava extends Budova {
    private Surovina surovina;
    public VrtnaSuprava(int riadok, int stlpec, Surovina surovina){
        super(riadok, stlpec);
        this.surovina = surovina;
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

