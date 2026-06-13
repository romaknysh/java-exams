package exam2;

public class Cislo implements CastVyrazu{
    private double hodnota;

    public Cislo(double hodnota){
        this.hodnota = hodnota;
    }

    @Override
    public String getReprezentacia(){
        return String.format("%.3f", this.hodnota);
    }

    public double getHodnota(){
        return this.hodnota;
    }
}
