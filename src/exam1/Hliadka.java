package exam1;

public class Hliadka implements Strazca {
    private Pozicia pozicia;
    private Smer smer;

    public Hliadka(Pozicia pozicia, Smer smer) {
        this.pozicia = pozicia;
        this.smer = smer;
    }

    @Override
    public boolean aktualizuj(Pozicia utecenec) {
        Pozicia nova = this.pozicia.posun(this.smer);
        if (!nova.jePlatna(Pozicia.ROZMER) || nova.jeKrovie()) {
            this.smer = this.smer.getOpacny();
        } else {
            this.pozicia = nova;
        }

        for (int i = 1; i <= 3; i++) {
            Pozicia kontrola = this.pozicia;
            for (int j = 0; j < i; j++) {
                kontrola = kontrola.posun(this.smer);
            }
            if (kontrola.jeKrovie()) return false;
            if (kontrola.jeRovnaka(utecenec)) return true;
        }
        return false;
    }

    @Override
    public char getReprezentacia() {
        if (this.smer == Smer.VPRAVO) return '>';
        return '<';
    }

    @Override
    public boolean jeNa(Pozicia pozicia) {
        return this.pozicia.jeRovnaka(pozicia);
    }
}