package exam6;

public class Jazda extends Policko{
    private int cenaZaJazdu;
    private String autoznackaVozidla;

    public Jazda(int cisloPolicka, int cenaZaJazdu, String autoznackaVozidla){
        super(cisloPolicka);
        this.cenaZaJazdu = cenaZaJazdu;
        this.autoznackaVozidla = autoznackaVozidla;
    }

    @Override
    public int vykonaj(Autosalon okruh, int financieHraca) {
        return super.vykonaj(okruh, financieHraca);
    }

    public String getZnackaVozidla(){
        return this.autoznackaVozidla;
    }
}
