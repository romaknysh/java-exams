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
        System.out.println("Policko cislo " + getCisloPolicka());
        System.out.println("Absolvujes skusobnu jazdu na vozidle " + this.autoznackaVozidla + " v cene: " + this.cenaZaJazdu + " penazi");
        return financieHraca - this.cenaZaJazdu;
    }

    public String getZnackaVozidla(){
        return this.autoznackaVozidla;
    }
}
