/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt_itnetwork_v2;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Stanislav Kus
 */
public class UzivatelskeRozhrani {

    private Databaze_pojistencu pojistenciDatabaze;
    private Scanner scanner;
    private boolean spravneZadani;

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
    protected void zobrazUvodniObrazovku() {
        System.out.println("–––––––––––––––––––––––––––––––––");
        System.out.println("Evidence pojištěných");
        System.out.println("–––––––––––––––––––––––––––––––––");
        System.out.println("Vyberte si akci:");
        System.out.println("1 – Přidat nového pojištěného");
        System.out.println("2 – Vypsat všechny pojištěné");
        System.out.println("3 – Vyhledat pojištěného");
        System.out.println("4 – Konec");
    }

    /**
     * metoda sloužící k ověření, zda zadaný text (např. jméno nebo příjmení)
     * obsahuje číslici
     *
     * @param analyzovanyText
     * @return true nebo false
     */
    private boolean obsahujeCislici(String analyzovanyText) {
        char[] cislice = analyzovanyText.toCharArray();
        for (char znak : cislice) {
            if (Character.isDigit(znak)) {
                return true;
            }
        }
        return false;
    }

    /**
     * metoda sloužící k ověření, zda je zadaný text (např. jméno nebo příjmení)
     * prázdný
     *
     * @param analyzovanyText
     * @return true nebo false
     */
    private boolean jePrazdny(String analyzovanyText) {
        return analyzovanyText.equals("");
    }

    /**
     * metoda pro získání jména
     *
     * @return jmenoPojisteneho
     */
    private String zadejJmeno() {
        /**
         * kontrola spravného zadání jména
         */
        spravneZadani = false;
        String jmenoPojisteneho = "";
        while (!spravneZadani) {
            System.out.println("Zadejte jméno pojištěnce:");
            try {
                jmenoPojisteneho = scanner.nextLine().trim();
                // kontrola, zda jméno obsahuje číslice                 
                if (obsahujeCislici(jmenoPojisteneho)) {
                    System.out.println("Jméno nemůže obsahovat číslice.");
                } // kontrola, zda je jméno prázdné
                else if (jePrazdny(jmenoPojisteneho)) {
                    System.out.println("Jméno nemůže být prázdné");
                } else {
                    spravneZadani = true;
                }
            } catch (Exception vyjimka) {
                System.out.println("Chybně zadané jméno.");
            }
        }
        return jmenoPojisteneho;
    }

    /**
     * metoda pro získání příjmení
     *
     * @return prijmeniPojisteneho
     */
    private String zadejPrijmeni() {
        /**
         * kontrola správného zadání příjmení
         */
        spravneZadani = false;
        String prijmeniPojisteneho = "";
        while (!spravneZadani) {
            System.out.println("Zadejte příjmení pojištěnce:");
            try {
                prijmeniPojisteneho = scanner.nextLine().trim();
                // kontrola, zda příjmení obsahuje číslice
                if (obsahujeCislici(prijmeniPojisteneho)) {
                    System.out.println("Příjmení nemůže obsahovat číslice.");
                } // kontrola, zda je příjmení prázdné
                else if (jePrazdny(prijmeniPojisteneho)) {
                    System.out.println("Příjmení nemůže být prázdné");
                } else {
                    spravneZadani = true;
                }
            } catch (Exception vyjimka) {
                System.out.println("Chybně zadané příjmení.");
            }
        }
        return prijmeniPojisteneho;
    }

    /**
     * metoda pro získání telefonního čísla
     *
     * @return telefonPojisteneho
     */
    private String zadejTelefon() {
        /**
         * kontrola, zda uživatel správně zadal telefonní číslo
         */
        String telefonPojisteneho = "";
        spravneZadani = false;
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
     * metoda pro získání věku
     *
     * @return vekPojisteneho
     */
    private int zadejVek() {
        /**
         * kontrola, zda uživatel správně zadal věk
         */
        int vekPojisteneho = 0;
        spravneZadani = false;
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
    protected void pridejPojistence() {
        pojistenciDatabaze.vlozZaznamPojistence(zadejJmeno(), zadejPrijmeni(), zadejVek(), zadejTelefon());
        stiskniEnter();
    }

    /**
     * String oznamující uživateli, že je databáze prázdná
     *
     * @return Databáze pojištěnců je prázdná.
     */
    private String prazdnaDatabaze() {
        return "Databáze pojištěnců je prázdná.";
    }

    /**
     * String oznamující uživateli, že pojištěnec nebyl nalezen
     *
     * @return Daný pojištěnec nebyl nalezen.
     */
    private String pojistenecNenalezen() {
        return "\n" + "Daný pojištěnec nebyl nalezen.";
    }

    private String pojistenecNalezen() {
        return "\n" + "Nalezený pojištěnec: ";
    }

    /**
     * metoda pro výpis pojištěnců
     */
    protected void vypisPojistence() {
        if (pojistenciDatabaze.jePrazdna(pojistenciDatabaze.getZaznamyPojistencu())) {
            System.out.println(prazdnaDatabaze());
        } else {
            pojistenciDatabaze.vypisZaznamyPojistencu(pojistenciDatabaze.getZaznamyPojistencu());
        }
        stiskniEnter();
    }

    /**
     * metoda pro nalezení pojištěnce
     */
    protected void najdiPojistence() {

        Pojistenec hledanyPojistenec;

        if (pojistenciDatabaze.jePrazdna(pojistenciDatabaze.getZaznamyPojistencu())) {
            System.out.println(prazdnaDatabaze());
        } else {
            hledanyPojistenec = pojistenciDatabaze.najdiZaznamPojistence(zadejJmeno(), zadejPrijmeni());
            if (hledanyPojistenec == null) {
                System.out.println(pojistenecNenalezen());
            } else {
                System.out.println(pojistenecNalezen() + hledanyPojistenec);
            }
        }
        stiskniEnter();
    }

    /**
     * metoda vyzývající uživatele k pokračování stisknutím klávesy Enter
     */
    private void stiskniEnter() {

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
