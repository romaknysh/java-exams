package exam1;

public class Pozicia {
    public final static int ROZMER = 5;
    private int riadok;
    private int stlpec;

    public Pozicia(int riadok, int stlpec){
        this.riadok = riadok;
        this.stlpec = stlpec;
    }

    public int getStlpec() {
        return stlpec;
    }

    public int getRiadok() {
        return riadok;
    }

    public boolean jeRovnaka(Pozicia druha){
        if(this.stlpec == druha.getStlpec()){
            if (this.riadok == druha.getRiadok()){
                return true;
            }
        }
        return false;
    }

    public boolean jePlatna(int rozmer){
        if ((this.stlpec < ROZMER && this.stlpec >= 0) && (this.riadok < ROZMER && this.riadok >= 0)) return true;
        return false;
    }

    public boolean jeKrovie(){
        if (this.riadok % 2 != 0 && (this.stlpec == 0 || this.stlpec == ROZMER-1)) return true;
        else return false;
    }

    public Pozicia posun(Smer smer){
        switch (smer){
            case VPRAVO -> {
                return (new Pozicia(this.riadok, this.stlpec+1));
            }
            case VLAVO -> {
                return (new Pozicia(this.riadok, this.stlpec-1));
            }
            case DOLE -> {
                return (new Pozicia(this.riadok+1, this.stlpec));
            }
            case HORE -> {
                return (new Pozicia(this.riadok-1, this.stlpec));
            }
            default -> {
                return this;
            }
        }
    }
}
