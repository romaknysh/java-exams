package exam4;

import java.util.Optional;

public class VrtnaSuprava extends Budova {
    private Surovina surovina;

    public VrtnaSuprava(int riadok, int stlpec, Surovina surovina) {
        super(riadok, stlpec);
        if (surovina != Surovina.ZELEZNA_RUDA && surovina != Surovina.MEDENA_RUDA) {
            throw new IllegalArgumentException("Nespravna surovina");
        }
        this.surovina = surovina;
    }

    @Override
    public void aktualizuj(HernySvet hernySvet) {
        if (aktualnyPlan != null) {
            aktualnyPlan.aktualizuj();
            Optional<Surovina> vyrobena = aktualnyPlan.getVyrobenaSurovina();
            if (vyrobena.isPresent()) {
                pridajSurovinuNaSklad(vyrobena.get());
                System.out.println("    Budova Vrtna suprava na " + getRiadok() + "," + getStlpec() + " vyrobila predmet " + vyrobena.get() + " (pocet poloziek na sklade: " + getSkladSize() + ")");
                aktualnyPlan = null;
            }
        }
        if (aktualnyPlan == null) {
            aktualnyPlan = zacniProdukciu().orElse(null);
            if (aktualnyPlan != null) {
                System.out.println("    Budova Vrtna suprava na " + getRiadok() + "," + getStlpec() + " zacala vyrobu " + aktualnyPlan.getPopis());
            }
        }
    }

    @Override
    protected boolean ziskajSurovinuVOkolo(HernySvet hernySvet, Surovina surovina) {
        return false;
    }

    @Override
    protected Optional<VyrobnyPlan> zacniProdukciu() {
        return Optional.of(new VyrobnyPlan(this.surovina, 4));
    }
}