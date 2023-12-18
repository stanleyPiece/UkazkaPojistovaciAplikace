/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt_itnetwork_v2;

import java.util.Scanner;

/**
 *
 * @author Stanislav Kus
 */
public class UzivatelskeRozhrani {

    private Databaze_pojistencu pojistenciDatabaze;
    private Scanner scanner;

    /**
     * instance uživatelského rozhraní
     *
     * @param scanner
     */
    UzivatelskeRozhrani(Scanner scanner) {
        pojistenciDatabaze = new Databaze_pojistencu(scanner);
        this.scanner = scanner;
    }

    /**
     * metoda pro zobrazení úvodní obrazovky
     */
    void zobrazUvodniObrazovku() {
        System.out.println("–––––––––––––––––––––––––––––––––");
        System.out.println("Evidence pojištěných");
        System.out.println("–––––––––––––––––––––––––––––––––");
        System.out.println("Vyberte si akci:");
        System.out.println("1 – Přidat nového pojištěného");
        System.out.println("2 – Vypsat všechny pojištěné");
        System.out.println("3 – Vyhledat pojištěného");
        System.out.println("4 – Konac");
    }

    /**
     * pomocna metoda pro získání jména
     *
     * @return jmenoPojisteneho
     */
    private String zadejJmeno() {
        /**
         * kontrola spravného zadání jména
         */
        boolean spravneZadani = false;
        String jmenoPojisteneho = "";

        while (!spravneZadani) {
            System.out.println("Zadejte jméno pojištěnce:");
            try {
                jmenoPojisteneho = scanner.nextLine().trim();

                /**
                 * kontrola, zda jméno obsahuje číslice
                 */
                char[] cislice = jmenoPojisteneho.toCharArray();
                for (char znak : cislice) {
                    if (Character.isDigit(znak)) {
                        System.out.println("Jméno nemůže obsahovat číslice.");
                        spravneZadani = false;
                        break;
                    } else {
                        spravneZadani = true;
                    }
                }
            } catch (Exception vyjimka) {
                System.out.println("Chybně zadané jméno.");
            }
        }
        return jmenoPojisteneho;
    }

    /**
     * pomocná metoda pro získání příjmení
     *
     * @return prijmeniPojisteneho
     */
    private String zadejPrijmeni() {
        /**
         * kontrola správného zadání příjmení
         */
        boolean spravneZadani = false;
        String prijmeniPojisteneho = "";
        while (!spravneZadani) {
            System.out.println("Zadejte příjmení pojištěnce:");

            try {
                prijmeniPojisteneho = scanner.nextLine().trim();

                /**
                 * kontrola, zda příjmení obsahuje číslice
                 */
                char[] cislice = prijmeniPojisteneho.toCharArray();
                for (char znak : cislice) {
                    if (Character.isDigit(znak)) {
                        System.out.println("Příjmení nemůže obsahovat číslice.");
                        spravneZadani = false;
                        break;
                    } else {
                        spravneZadani = true;
                    }
                }
            } catch (Exception vyjimka) {
                System.out.println("Chybně zadané příjmení.");
            }
        }
        return prijmeniPojisteneho;
    }

    /**
     * pomocná metoda pro získání telefonního čísla
     *
     * @return telefonPojisteneho
     */
    private String zadejTelefon() {

        /**
         * kontrola, zda uživatel správně zadal telefonní číslo
         */
        String telefonPojisteneho = "";
        boolean spravneZadani = false;
        while (!spravneZadani) {
            System.out.println("Zadejte telefonní číslo pojištěnce:");
            try {
                telefonPojisteneho = scanner.nextLine();
                spravneZadani = true;
            } catch (Exception vyjimka) {
                System.out.println("Chybně zadané telefonní číslo.");
            }
        }
        return telefonPojisteneho;
    }

    /**
     * pomocná metoda pro získání věku
     *
     * @return vekPojisteneho
     */
    private int zadejVek() {

        /**
         * kontrola, zda uživatel správně zadal věk
         */
        int vekPojisteneho = 0;
        boolean spravneZadani = false;
        while (!spravneZadani) {
            System.out.println("Zadejte věk pojištěnce:");
            try {
                vekPojisteneho = Integer.parseInt(scanner.nextLine());
                spravneZadani = true;
            } catch (Exception vyjimka) {
                System.out.println("Chybně zadaný věk.");
            }
        }
        return vekPojisteneho;
    }

    /**
     * metoda pro přidání pojištěnce
     */
    void pridejPojistence() {

        pojistenciDatabaze.vlozZaznamPojistence(zadejJmeno(), zadejPrijmeni(), zadejVek(), zadejTelefon());
        stiskniEnter();

    }

    /**
     * metoda pro výpis pojištěnců
     */
    void vypisPojistence() {
        if (!pojistenciDatabaze.getZaznamyPojistencu().isEmpty()) {
            for (Pojistenec pojistenec : pojistenciDatabaze.getZaznamyPojistencu()) {
                System.out.println(pojistenec);
            }
            stiskniEnter();
        } else {
            System.out.println("Databáze pojištěnců je prázdná.");
        }
    }

    /**
     * metoda pro nalezení pojištěnce
     */
    void najdiPojistence() {
        if (!pojistenciDatabaze.getZaznamyPojistencu().isEmpty()) {
            for (Pojistenec pojistenec : pojistenciDatabaze.getZaznamyPojistencu()) {
                if ((zadejJmeno().equals(pojistenec.getJmeno())) && (zadejPrijmeni().equals(pojistenec.getPrijmeni()))) {
                    System.out.println("\n" + ("Nalezený pojištěnec: " + pojistenec));
                    stiskniEnter();
                } else {
                    System.out.println("\n" + "Daný pojištěnec nebyl nalezen.");
                }
            }
        } else {
            System.out.println("Databáze pojištěnců je prázdná.");
        }
    }

    /**
     * metoda vyzývající uživatele k pokračování stisknutím klávesy Enter
     */
    void stiskniEnter() {

        while (true) {
            System.out.println("");
            System.out.println("Pokračujte stisknutím klávesy Enter...");
            System.out.println("");
            String stisknutyEnter = scanner.nextLine();
            if (stisknutyEnter.isEmpty()) {
                break;
            }
        }
    }
}
