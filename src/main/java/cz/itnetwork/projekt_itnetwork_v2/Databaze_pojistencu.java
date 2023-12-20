/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt_itnetwork_v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

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
     * metoda ke zjištění, zda je databáze prázdná
     * 
     * @return true nebo false
     */
    protected boolean jePrazdna () {
        return pojistenci.isEmpty();
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
     * metoda pro výpis pojištěnců
     * @param pojistenci 
     */
    protected void vypisZaznamyPojistencu(List<Pojistenec> pojistenci) {
            pojistenci.stream()
                      .forEach(System.out::println);
    }
    
    protected Pojistenec najdiZaznamPojistence (String jmeno, String prijmeni) {
            return pojistenci.stream()
                                                               .filter(pojistenec -> pojistenec.getJmeno().equals(jmeno) &&
                                                                       pojistenec.getPrijmeni().equals(prijmeni))
                                                               .findFirst()
                                                               .orElse(null);
            
    }    
}
