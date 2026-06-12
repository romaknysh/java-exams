package exam1;

public enum Smer {
    HORE,
    DOLE,
    VPRAVO,
    VLAVO;

    public Smer getOpacny(){
        switch (this){
            case VPRAVO -> {
                return VLAVO;
            }
            case VLAVO -> {
                return VPRAVO;
            }
            case HORE -> {
                return DOLE;
            }
            case DOLE -> {
                return HORE;
            }
            default -> {
                System.out.println("Nespravny smer");
                return null;
            }
        }
    }
}
