/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cz.itnetwork.projekt_itnetwork_v2;

import java.util.Scanner;

/**
 *
 * @author Stanislav Kus
 */
public class Main {

    public static void spustitProgram() {

        Scanner scanner = new Scanner(System.in, "Windows-1250");

        UzivatelskeRozhrani uzivatelskeRozhrani = new UzivatelskeRozhrani(scanner);

        /**
         * proměnná pro uložení volby vybrané uživatelem
         */
        int akce = 0;

        /**
         * kontrola, zda uživatel zadal číslo, a ne například písmeno
         */
        while ((akce != 4)) {
            uzivatelskeRozhrani.zobrazUvodniObrazovku();
            try {
                akce = Integer.parseInt(scanner.nextLine());
            } catch (Exception vyjimka) {
                System.out.println("Nezadali jste číslo.");
            }

            System.out.println("");

            switch (akce) {
                case 1:
                    uzivatelskeRozhrani.pridejPojistence();
                    break;

                case 2:
                    uzivatelskeRozhrani.vypisPojistence();
                    break;

                case 3:
                    uzivatelskeRozhrani.najdiPojistence();
                    break;

                case 4: 
                    System.out.println("Děkuji za použití aplikace.");
                    break;
                
                default:
                    System.out.println("Nesprávná volba. Proveďte nový výběr.\n");
                    break;
            }
        }        
    }

    public static void main(String[] args) {

        spustitProgram();
    }
}
