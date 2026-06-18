package exam4;

import java.util.Optional;

public class VyrobnyPlan {
    private int trvanie;
    private Surovina surovina;
    private int krok;

    public VyrobnyPlan(Surovina surovina, int trvanie) {
        this.surovina = surovina;
        this.trvanie = trvanie;
        this.krok = 0;
    }
    public void aktualizuj(){
        if (this.krok != this.trvanie) krok+=1;
    }

    public Optional<Surovina> getVyrobenaSurovina(){
        if (this.krok == this.trvanie){
            return Optional.of(surovina);
        } return Optional.empty();
    }

    public String getPopis() {
        return this.surovina + " - trvanie: " + (this.trvanie - this.krok);
    }
}
