package exam6;

public class Vyhra extends Policko{
    public Vyhra(int cisloPolicka){
        super(cisloPolicka);
    }

    @Override
    public int vykonaj(Autosalon okruh, int financieHraca) {
        System.out.println("Policko cislo " + getCisloPolicka());
        System.out.println("Si na vyhernom policku, ziskavas dotaciu za uspesnu jazdu");
        return financieHraca + 9000;
    }
}
