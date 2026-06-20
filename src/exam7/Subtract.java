package exam7;

public class Subtract implements Instrukcia {
    private char ciel;
    private char operand;

    public Subtract(char ciel, char operand){
        this.ciel = ciel;
        this.operand = operand;
    }

    @Override
    public void vykonaj(Procesor procesor) {

    }
}
