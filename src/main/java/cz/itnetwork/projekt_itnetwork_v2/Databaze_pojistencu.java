/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt_itnetwork_v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


/**
 *
 * @author Stanislav Kus
 */
public class Databaze_pojistencu {

    private List<Pojistenec> pojistenci;
    private List<Pojistenec> pojistenciNemodifikovatelni;
    private Scanner scanner;
    //private List<Pojistenec> pojistenciNemodifikovatelni;

    /**
     * instance databáze
     */
    Databaze_pojistencu(Scanner scanner) {
        pojistenci = new ArrayList<>();
        pojistenciNemodifikovatelni = Collections.unmodifiableList(pojistenci);
        this.scanner = scanner;
    }
    
    /**
     * metoda pro navrácení nemodifikovatelného seznamu záznamů pojištěnců v databázi
     * @return pojistenci
     */
    protected List<Pojistenec> getZaznamyPojistencu() {
        return pojistenciNemodifikovatelni;
    }        

    /**
     * metoda pro vložení záznamu pojištěnce do databáze
     * @param jmeno
     * @param prijmeni
     * @param telefonniCislo
     * @param vek
     */
    protected void vlozZaznamPojistence(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telefonniCislo));
    }        
    
    /**
     * metoda pro výpis záznamů pojištěnců
     * @param pojistenci 
     */
    protected void vypisZaznamyPojistencu(List<Pojistenec> pojistenci) {
            pojistenci.stream()
                      .forEach(System.out::println);
    }
    
    /**
     * metoda pro nalezení záznamu pojištěnce
     * @param jmeno
     * @param prijmeni
     * @return 
     */
    protected Pojistenec najdiZaznamPojistence (String jmeno, String prijmeni) {
              Optional<Pojistenec> hledanyPojistenec = pojistenci.stream()
                                          .filter(pojistenec -> pojistenec.getJmeno().equals(jmeno) &&
                                                  pojistenec.getPrijmeni().equals(prijmeni))
                                          .findFirst();
                return hledanyPojistenec.orElse(null);
    }    
}
