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
        this.reprezentacia = "  ";
    }

    public String getReprezentacia(){
        return this.reprezentacia;
    }

    public int vykonaj(Autosalon okruh, int financieHraca){
        return 1;
    }

    protected int getCisloPolicka(){
        return this.cisloPolicka;
    }
}
