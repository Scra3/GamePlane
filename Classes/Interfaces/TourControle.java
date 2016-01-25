/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Interfaces;

import Classes.Avions.Avion;
import Classes.Exceptions.EcrasementAvionException;
import Classes.Piste;

/**
 *
 * @author scra
 */
public interface TourControle {
    void afficherAeroport();
    void atterirAvion(Piste unePiste, Avion unAvion)throws EcrasementAvionException;
    void survolerAvion()throws EcrasementAvionException;
    Piste[] getTabPiste();
    Avion trouverAvionVolant(String numSerie)throws EcrasementAvionException ;
}
