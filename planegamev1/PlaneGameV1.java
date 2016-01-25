/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planegamev1;

import Classes.Interfaces.TourControle;
import Classes.*;
import Classes.Avions.Avion;
import Classes.Exceptions.EcrasementAvionException;
import java.util.Scanner;

/**
 *
 * @author scra
 */
/*Controleur  des avions*/
public class PlaneGameV1 {

    public static void demarerJeuGestionAvion() {
        try {
            /*VARIABLES*/
            // création de l'aéoroport
            TourControle TourControle = new Aeoroport();
            String choixUtilisateur = ""; // enregistre le choix de l'utilisateur
            String secondChoixUtilisateur = "";
            Scanner sc = new Scanner(System.in);
            Avion unAvion;
            Piste[] uneTabPiste;
            // affichage de l'initialisatio nde l'aéoroport
            TourControle.afficherAeroport();

            while (!choixUtilisateur.equals("3")) {

                System.out.println(" ALBAN BERTOLINI \n Veuillez saisir un choix : \n 1)Faire survoler les avions \n 2)Faire atterrir un avion \n 3) Fin de la journée de travail");
                choixUtilisateur = sc.nextLine();
                System.out.println("Vous avez saisi : " + choixUtilisateur);
                if (choixUtilisateur.equals("1") || choixUtilisateur.equals("2")) {
                    // survoler les avions
                    try {
                        if (choixUtilisateur.equals("1")) {
                            TourControle.survolerAvion();
                        } // Faire atterir avion
                        else {

                            System.out.println("Veuillez saisir un numéro de piste ");
                            choixUtilisateur = sc.nextLine();
                            System.out.println("Et un numéro de série d'avion");
                            secondChoixUtilisateur = sc.nextLine();

                            // Recherche de l'avion
                            uneTabPiste = TourControle.getTabPiste();
                            unAvion = TourControle.trouverAvionVolant(secondChoixUtilisateur);

                            /*Faire atterir un avion*/
                            if (Integer.parseInt(choixUtilisateur) > Aeoroport.NOMBRE_PISTE - 1) {
                                throw new EcrasementAvionException("Erreur de gestion de piste !");
                            }
                            TourControle.atterirAvion(uneTabPiste[Integer.parseInt(choixUtilisateur)], unAvion);
                        }
                        // affichage de l'aéoroport
                        TourControle.afficherAeroport();
                    } catch (EcrasementAvionException e) {
                        System.out.println(e.getMessage());
                        // on termine la boucle de proposition d'évènement à l'utilisateur
                        choixUtilisateur = "3";
                        // on stop le thread
                        Ciel.running = false;
                    }

                } else if (!choixUtilisateur.equals("3")) {
                    System.out.println("Veuillez saisir un choix proposé");
                } else {
                    // stop thread
                    Ciel.running = false;
                }
            }
            System.out.println("Bonne soirée");
        } finally {
            System.gc();
        }
    }

    public static void main(String[] args) {
        demarerJeuGestionAvion();
    }

}
