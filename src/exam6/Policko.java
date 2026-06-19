package exam6;

public class Policko {
    private int cisloPolicka;
    private String reprezentacia;

    protected Policko(int cisloPolicka, String reprezentacia){
        this.cisloPolicka = cisloPolicka;
        this.reprezentacia = reprezentacia;
    }

    public Policko(int cisloPolicka){
        this.cisloPolicka = cisloPolicka;
        this.reprezentacia = String.valueOf(this.cisloPolicka);
    }

    public String getReprezentacia(){
        if (this.reprezentacia.length() < 2){
            return " " + this.reprezentacia;
        } else return this.reprezentacia;
    }

    public int vykonaj(Autosalon okruh, int financieHraca){
        return financieHraca;
    }

    protected int getCisloPolicka(){
        return this.cisloPolicka;
    }
}
