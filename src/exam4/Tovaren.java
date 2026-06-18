package exam4;

import java.util.Optional;

public class Tovaren extends Budova {

    public Tovaren(int riadok, int stlpec) {
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
                System.out.println("    Budova Tovaren na " + getRiadok() + "," + getStlpec() + " vyrobila predmet " + vyrobena.get() + " (pocet poloziek na sklade: " + getSkladSize() + ")");
                aktualnyPlan = null;
            }
        }
        if (aktualnyPlan == null) {
            aktualnyPlan = zacniProdukciu().orElse(null);
            if (aktualnyPlan != null) {
                System.out.println("    Budova Tovaren na " + getRiadok() + "," + getStlpec() + " zacala vyrobu " + aktualnyPlan.getPopis());
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
        boolean maZelezny = ziskajSurovinuVOkolo(hernySvet, Surovina.ZELEZNY_PLAT);
        boolean maMedeny = ziskajSurovinuVOkolo(hernySvet, Surovina.MEDENY_PLAT);
        if (maZelezny && maMedeny) {
            return Optional.of(new VyrobnyPlan(Surovina.ELEKTRONICKY_OBVOD, 6));
        }
        if (maMedeny) {
            return Optional.of(new VyrobnyPlan(Surovina.KABEL, 2));
        }
        if (maZelezny) {
            pridajSurovinuNaSklad(Surovina.ZELEZNY_PLAT);
        }
        return Optional.empty();
    }
}