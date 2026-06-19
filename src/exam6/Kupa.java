package exam6;

public class Kupa extends Policko{
    public Kupa(int cisloPolicka){
        super(cisloPolicka);
    }

    @Override
    public int vykonaj(Autosalon okruh, int financieHraca) {
        return super.vykonaj(okruh, financieHraca);
    }
}
