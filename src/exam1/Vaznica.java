package exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Vaznica {
    private Pozicia utecenec;
    private List<Strazca> strazcovia;

    public Vaznica(){
        this.utecenec = new Pozicia(0, 0);
        this.strazcovia = new ArrayList<>();
        this.strazcovia.add(new Hliadka(new Pozicia(1, 1), Smer.VPRAVO));
        this.strazcovia.add(new Hliadka(new Pozicia(2, 2), Smer.VLAVO));
        this.strazcovia.add(new StrazcaVoVezi(new Pozicia(3, 2)));
    }

    public void posunUtecenca(Smer smer){
        Pozicia nova = utecenec.posun(smer);
        if (nova.jePlatna(Pozicia.ROZMER)){
            utecenec = nova;
        }
    }

    public boolean aktualizujStrazcov(){
        for (Strazca s : strazcovia){
            if (s.aktualizuj(utecenec)) return true;
        }
        return false;
    }

    public void vypis(){
        for (int r = 0; r<Pozicia.ROZMER; r++){
            for (int s = 0; s<Pozicia.ROZMER; s++){
                Pozicia p = new Pozicia(r, s);
                if(p.jeRovnaka(utecenec)){
                    System.out.print('u');
                } else if (p.jeKrovie()){
                    System.out.print('#');
                } else {
                    Optional<Strazca> strazca = getStrazcaNa(p);
                    if (strazca.isPresent()){
                        System.out.print(strazca.get().getReprezentacia());
                    } else {
                        System.out.print('.');
                    }
                }
            }
            System.out.println();
        }
    }

    public Optional<Strazca> getStrazcaNa(Pozicia pozicia){
        for (Strazca s : strazcovia){
            if (s.jeNa(pozicia)) return Optional.of(s);
        }
        return Optional.empty();
    }
}
