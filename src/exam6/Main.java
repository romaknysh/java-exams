package exam6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hra hra = new Hra("autosalon.dat");
        hra.vypisHry();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Zadaj pocet policok pre posun hraca");
            int pocet = sc.nextInt();
            if (pocet < 0) {
                break;
            }
            hra.posunHraca(pocet);
            hra.vypisHry();
        }
    }
}