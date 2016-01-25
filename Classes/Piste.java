/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Avions.Avion;

/**
 *
 * @author scra
 */
public class Piste {
    
    Avion  avion;
    Integer nombreTour = 0;
    Integer numPiste;
    Integer nombreTourMax;
    
    public Piste(Integer numPiste){
        this.avion = null; // permet de connaître si la piste est utilisé par un avion
        this.nombreTour = 0; // quand il attérit il gagne un tour : TOUR =+1
        this.numPiste = numPiste;
        this.nombreTourMax = 5;
    }

    public Integer getNombreTourMax() {
        return nombreTourMax;
    }

    public void setNombreTourMax(Integer nombreTourMax) {
        this.nombreTourMax = nombreTourMax;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    

    public Integer getNombreTour() {
        return nombreTour;
    }

    public void setNombreTour(Integer nombreTour) {
        this.nombreTour = nombreTour;
    }

    public Integer getNumPiste() {
        return numPiste;
    }

    public void setNumPiste(Integer numPiste) {
        this.numPiste = numPiste;
    }
    
    
}
