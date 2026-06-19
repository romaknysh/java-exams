package exam6;

public class Autosalon {
    private int rozmer;
    private Policko policka[];

    public Autosalon(int rozmer){
        if (rozmer % 2 == 0){
            this.rozmer = rozmer;
        } else this.rozmer = rozmer+1;
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

    public void vypis(int polickoHraca) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rozmer; i++) {
            if (i == polickoHraca) {
                sb.append("HH");
            } else {
                sb.append(this.policka[i].getReprezentacia());
            }
            if (i < this.rozmer - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
