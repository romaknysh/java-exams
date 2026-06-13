package exam2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Zadaj ciselny vyraz > ");
            String vstup = sc.nextLine();
            if (vstup.equals("koniec")) return;
            try {
                CiselnyVyraz vyraz = CiselnyVyraz.vytvorZRetazca(vstup);
                vyraz.vyries(new VyberacSPrioritou());
                System.out.println("- - - - - - - - - -");
                vyraz.vyries(new VyberacBezPriority());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}