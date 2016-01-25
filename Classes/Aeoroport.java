/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Interfaces.TourControle;
import Classes.Avions.Avion;
import Classes.Exceptions.EcrasementAvionException;
import Classes.Interfaces.LieuAtterrisage;
import java.util.LinkedList;
import java.util.List;

/**
 * @author scra
 */
public class Aeoroport implements TourControle, LieuAtterrisage {

    //Tableaux de pistes
    public static final Integer NOMBRE_PISTE = 3;

    public Piste[] tabPiste = new Piste[NOMBRE_PISTE];
    // Avions en vols
    public List<Avion> listeAvions;

    /*Un aéoroport contient 3 pistes*/
    //CONSTRUCTEUR
    public Aeoroport() {
        /*Créer 3 piste*/
        // Création des pistes dynamiques
        for (int i = 0; i < tabPiste.length; i++) {
            tabPiste[i] = new Piste(i);
        }
        //Liste des avions en vols
        this.listeAvions = new LinkedList();
        // création d'une instance du thread
        Ciel thread = new Ciel(this);
        // Activation du thread
        thread.start();
    }

    /*SET ANG GET*/
    public Piste[] getTabPiste() {
        return tabPiste;
    }

    public void setTabPiste(Piste[] tabPiste) {
        this.tabPiste = tabPiste;
    }

    public List getListeAvions() {
        return listeAvions;
    }

    public void setListeAvions(List listeAvions) {
        this.listeAvions = listeAvions;
    }
    // trouver un avion dans la liste des avions 

    @Override
    public Avion trouverAvionVolant(String numSerie) throws EcrasementAvionException {
        // Variable
        Avion unAvion = null;
        for (int i = 0; i < listeAvions.size(); i++) {
            
            if (Integer.toString(this.listeAvions.get(i).getNumSerie()).equals(numSerie)) {
                unAvion = listeAvions.get(i);
            }
        }
        if (unAvion == null) {
            throw new EcrasementAvionException("Avion introuvable ... Vous n'êtes pas assez réactif");
        }
        return unAvion;
    }

    @Override
    //ajouter un avion dans la liste des avions de l'aéoroport
    public void survoler(Avion unAvion) {
        this.listeAvions.add(unAvion);
    }

    @Override
    // faire atterrir un avion 
    public void atterirAvion(Piste unePiste, Avion unAvion) throws EcrasementAvionException {
       
        Avion avionPiste = unePiste.getAvion();
        if (avionPiste != null) {
            throw new EcrasementAvionException("Piste non libre ... HELPP !!! BROOOO");
        } else {
            // on ajoute l'avion à la piste
            unePiste.setAvion(unAvion);
            // on supprime l'avion des avions en vol
            listeAvions.remove(unAvion);
            //survoler avion
            this.survolerAvion();
        }
    }

    @Override
    public void survolerAvion() throws EcrasementAvionException {

        // VARIABLES
        Piste unePiste; // une piste
        Avion unAvion; // un avion

        listeAvions = this.getListeAvions();
        tabPiste = this.getTabPiste();

        // -1 essence pour avions qui ne sont pas sur la piste 
        // + 1 tour pour avion qui est sur la piste
        System.out.println("Survols des avions : ");
        for (int i = 0; i < listeAvions.size(); i++) {
            unAvion = listeAvions.get(i);
            // - 1 essence, l'avion est dans les aires 
            unAvion.setQtEssence(unAvion.getQtEssence() - 1);
            if (unAvion.getQtEssence() <= 0) {
                throw new EcrasementAvionException("Avion/Serie : " + unAvion.getTypeAvion() + "/" + unAvion.getNumSerie() + " : Plus d'essence HELPP");
            }
        }
        for (int a = 0; a < tabPiste.length; a++) {
            unePiste = tabPiste[a];
            // +1 tour si tour < tourMax
            // tour  +1
            unePiste.setNombreTour(unePiste.getNombreTour()+1);
         
            // libérer la piste et supprimer l'avion de la liste
            if (unePiste.getNombreTour() > 4) {
                tabPiste[a] = new Piste(a);
                setTabPiste(tabPiste);
            }
        }
    }

    @Override
    public void afficherAeroport() {

        Avion unAvion; // unAvion de type avion
        Piste unePiste; // unePiste de type Piste
        String numSerie; // numéro de série avion
        String numSerie2; // numéro de série avion
        String message;// message affiché sur la console

        //Afficher Avions en survol 
        listeAvions = this.getListeAvions();

        // Etat des pistes ( Pour l'énoncé il y en a 3 )
        tabPiste = this.getTabPiste();
        // Affichage des états de la piste
        System.out.println("Etats des pistes : ");
        for (int a = 0; a < tabPiste.length; a++) {

            unePiste = tabPiste[a];
            unAvion = unePiste.getAvion();

            if (unAvion != null) {
                message = "(" + a + ")" + " (Occupe) Avions sur piste  NSS : (" + unAvion.getNumSerie() + " , ESS : " + unAvion.getQtEssence() + " ) " + unAvion.getTypeAvion() + " ( nbTours : " + unePiste.getNombreTour() + "/" + unePiste.getNombreTourMax() + ") ";
            } else {
                message = "(" + a + ")" + "Libre ";
            }
            // Out console 

            System.out.println(message);
        }
        //Affciher avions 
        System.out.println("Liste des avions en survols : ");
        for (int i = 0; i < listeAvions.size(); i++) {
            message = "( NS :" + listeAvions.get(i).getNumSerie() + " , ESS : " + listeAvions.get(i).getQtEssence() + " ) " + listeAvions.get(i).getTypeAvion();
            System.out.println(message);
        }

    }
}
