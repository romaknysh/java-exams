package exam7;

public class Load implements Instrukcia {
    private char register;
    private int hodnota;
    public Load(char register, int hodnota){
        this.hodnota = hodnota;
        this.register = register;
    }

    @Override
    public void vykonaj(Procesor procesor) {
        procesor.getRegistre().nastav(this.register, this.hodnota);
    }
}
