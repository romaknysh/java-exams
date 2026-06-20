package exam7;

public class Move implements Instrukcia {
    private char ciel;
    private int hodnota;

    public Move(char ciel, int hodnota){
        this.ciel = ciel;
        this.hodnota = hodnota;
    }

    @Override
    public void vykonaj(Procesor procesor) {

    }
}
