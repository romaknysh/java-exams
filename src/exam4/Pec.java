package exam4;

import java.util.Optional;

public class Pec extends Budova {

    public Pec(int riadok, int stlpec) {
        super(riadok, stlpec);
    }

    @Override
    public void aktualizuj(HernySvet hernySvet) {
        this.hernySvet = hernySvet;
        if (aktualnyPlan != null) {
            aktualnyPlan.aktualizuj();
            Optional<Surovina> vyrobena = aktualnyPlan.getVyrobenaSurovina();
            if (vyrobena.isPresent()) {
                pridajSurovinuNaSklad(vyrobena.get());
                System.out.println("    Budova Pec na " + getRiadok() + "," + getStlpec() + " vyrobila predmet " + vyrobena.get() + " (pocet poloziek na sklade: " + getSkladSize() + ")");
                aktualnyPlan = null;
            }
        }
        if (aktualnyPlan == null) {
            aktualnyPlan = zacniProdukciu().orElse(null);
            if (aktualnyPlan != null) {
                System.out.println("    Budova Pec na " + getRiadok() + "," + getStlpec() + " zacala vyrobu " + aktualnyPlan.getPopis());
            }
        }
    }

    @Override
    protected boolean ziskajSurovinuVOkolo(HernySvet hernySvet, Surovina surovina) {
        int r = getRiadok();
        int s = getStlpec();
        int[][] smery = {{r-1, s}, {r, s+1}, {r, s-1}, {r+1, s}};
        for (int[] smer : smery) {
            Optional<Budova> budova = hernySvet.getBudova(smer[0], smer[1]);
            if (budova.isPresent() && budova.get().vyberSurovinuZoSkladu(surovina)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected Optional<VyrobnyPlan> zacniProdukciu() {
        if (ziskajSurovinuVOkolo(hernySvet, Surovina.ZELEZNA_RUDA)) {
            return Optional.of(new VyrobnyPlan(Surovina.ZELEZNY_PLAT, 4));
        }
        if (ziskajSurovinuVOkolo(hernySvet, Surovina.MEDENA_RUDA)) {
            return Optional.of(new VyrobnyPlan(Surovina.MEDENY_PLAT, 5));
        }
        return Optional.empty();
    }
}