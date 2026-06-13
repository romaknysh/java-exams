package exam2;

public class Operacia implements CastVyrazu {
    private char operacia;

    public Operacia (char operacia){
        this.operacia = operacia;
    }

    public double vypocitaj(double laveCislo, double praveCislo){
        switch (this.operacia){
            case ('+'): return laveCislo + praveCislo;
            case ('-'): return laveCislo - praveCislo;
            case ('/'): return laveCislo / praveCislo;
            case ('*'): return laveCislo * praveCislo;
            default: throw new RuntimeException("Neplatna operacia: " + this.operacia);
        }
    }

    @Override
    public String getReprezentacia(){
        return String.valueOf(this.operacia);
    }

    public boolean jeHladanaOperacia(char[] hladaneOperacie){
        for (char operacia : hladaneOperacie){
            if (operacia == this.operacia) return true;
        }
        return false;
    }
}
