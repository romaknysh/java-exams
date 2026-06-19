package exam6;

public class Autosalon {
    private int rozmer;
    private Policko policka[];

    public Autosalon(int rozmer){
        this.rozmer = rozmer;
        this.policka = new Policko[this.rozmer];
    }

    public void nastavPolicko(int poradiePolicka, Policko novePolicko){
        this.policka[poradiePolicka] = novePolicko;
    }

    public Policko getPolicko(int PoradiePolicka) {
        return this.policka[PoradiePolicka];
    }

    public int getPocetPolicok(){
        return this.rozmer;
    }

    public void vypis (int polickoHraca){
        System.out.println(this.policka[polickoHraca]);
    }
}
