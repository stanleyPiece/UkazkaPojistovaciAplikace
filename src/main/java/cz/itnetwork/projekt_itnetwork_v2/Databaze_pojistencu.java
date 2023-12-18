/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt_itnetwork_v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Stanislav Kus
 */
public class Databaze_pojistencu {

    private List<Pojistenec> pojistenci;
    private Scanner scanner;    

    /**
     * instance databáze
     */
    Databaze_pojistencu(Scanner scanner) {
        pojistenci = new ArrayList<>();
        this.scanner = scanner;
    }

    /**
     * metoda pro vložení záznamu pojištěnce do databáze
     * @param jmeno
     * @param prijmeni
     * @param telefonniCislo
     * @param vek
     */
    void vlozZaznamPojistence(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telefonniCislo));
    }

    /**
     * metoda pro získání záznamů pojištěnců z databáze
     * @return pojistenci
     */
    List<Pojistenec> getZaznamyPojistencu() {
        return Collections.unmodifiableList(pojistenci);
    }    
}
