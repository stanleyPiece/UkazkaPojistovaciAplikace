/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt_itnetwork_v2;

/**
 *
 * @author Stanislav Kus
 */
public class Pojistenec {

    /**
     * jméno pojištěnce
     */
    private String jmeno;

    /**
     * příjmení pojištěnce
     */
    private String prijmeni;

    /**
     * telefonní číslo pojištěnce
     */
    private String telefonniCislo;

    /**
     * věk pojištěnce
     */
    private int vek;

    /**
     * nová instance pojištěnce
     *
     * @param jmeno
     * @param prijmeni
     * @param telefonniCislo
     * @param vek
     */
    Pojistenec(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefonniCislo = telefonniCislo;
        this.vek = vek;
    }

    /**
     * getter potřebný ke správnému fungování metody k nalezení pojištěného v databázi
     * @return jmeno
     */
    protected String getJmeno() {
        return jmeno;
    }

    /**
     * getter potřebný ke správnému fungování metody k nalezení pojištěného v databázi
     * @return prijmeni
     */
    protected String getPrijmeni() {
        return prijmeni;
    }

    /**
     * metoda pro vrácení textové podoby pojištěnce
     * @return textová podoba pojištěnce
     */
    @Override
    public String toString() {
        return jmeno + "  " + prijmeni + "  " + vek + "  " + telefonniCislo;
    }
}
