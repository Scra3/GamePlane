/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Avions;

/**
 *
 * @author scra
 */
public abstract class Avion {

    //DECLARATION DES VARIABLES
    protected Integer qtEssence;
    protected String typeAvion;
    protected Integer numSerie;
    protected static Integer compteurNumSerie = 0;

    public Avion(Integer qtEssence, String typeAvion, Integer numSerie) {
        this.qtEssence = qtEssence;
        this.typeAvion = typeAvion;
        this.numSerie = numSerie;
    }

    public static Integer compteurNumSerieGenerer() {
        compteurNumSerie = compteurNumSerie + 1;
        return compteurNumSerie;
    }

    /*SET ET GET*/
    public Integer getQtEssence() {
        return qtEssence;
    }

    public void setQtEssence(Integer qtEssence) {
        this.qtEssence = qtEssence;
    }

    public String getTypeAvion() {
        return typeAvion;
    }

    public void setTypeAvion(String typeAvion) {
        this.typeAvion = typeAvion;
    }

    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }

}
