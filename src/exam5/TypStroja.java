package exam5;

public enum TypStroja {
    LIETADLO,
    VRTULNIK;

    public double getUdrzba(){
        switch (this){
            case LIETADLO -> {
                return 500;
            }
            case VRTULNIK -> {
                return 200;
            }
            default -> {
                return 0;
            }
        }
    }
}
