package exam4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HernySvet {
    private List<Budova> budovy;
    public HernySvet(){
        this.budovy = new ArrayList<>();
    }

    public void pridajBudovu(Budova budova){
        this.budovy.add(budova);
    }

    public Optional<Budova> getBudova(int riadok, int stlpec){
        for (Budova budova : budovy){
            if (budova.jeNaPozicii(riadok, stlpec)){
                return Optional.of(budova);
            }
        } return Optional.empty();
    }

    public void vykonajKrok(){
        for (Budova budova : budovy){
            budova.aktualizuj(this);
        }
    }
}
