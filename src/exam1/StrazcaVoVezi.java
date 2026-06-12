package exam1;

public class StrazcaVoVezi implements Strazca{
    private Pozicia pozicia;
    private int krokyDoPozerania;
    private boolean pozeraSa;

    public StrazcaVoVezi(Pozicia pozicia){
        this.pozicia = pozicia;
        this.krokyDoPozerania = 5;
        this.pozeraSa = false;
    }

    @Override
    public boolean aktualizuj (Pozicia pozicia){
        if (this.krokyDoPozerania == 0){
            this.pozeraSa = true;
            this.krokyDoPozerania = 5;
            if (!pozicia.jeKrovie()){
                return true;
            }else{
                return false;
            }
        } else {
            this.krokyDoPozerania -= 1;
            this.pozeraSa = false;
            return false;
        }
    }

    @Override
    public char getReprezentacia(){
        if (this.pozeraSa){
            return 'V';
        } else{
            return (char) ('0' + krokyDoPozerania);
        }
    }

    @Override
    public boolean jeNa(Pozicia pozicia){
        if (pozicia.getRiadok() == this.pozicia.getRiadok() && pozicia.getStlpec() == this.pozicia.getStlpec()){
            return true;
        } else{
            return false;
        }
    }
}
