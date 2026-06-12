package exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vaznica v = new Vaznica();
        Scanner sc = new Scanner(System.in);
        while (true){
            v.vypis();
            String prikaz = sc.nextLine();
            switch (prikaz) {
                case "KONIEC" -> { return; }
                case "STOJ" -> { }
                case "HORE" -> v.posunUtecenca(Smer.HORE);
                case "DOLE" -> v.posunUtecenca(Smer.DOLE);
                case "VLAVO" -> v.posunUtecenca(Smer.VLAVO);
                case "VPRAVO" -> v.posunUtecenca(Smer.VPRAVO);
            }
            if (v.aktualizujStrazcov()) {
                v.vypis();
                System.out.println("Utecenec bol chyteny!");
                return;
            }
        }
    }
}
