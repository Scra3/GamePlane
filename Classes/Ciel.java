/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Avions.Avion;
import Classes.Avions.AvionTypeA;
import Classes.Avions.AvionTypeB;
import Classes.Avions.AvionTypeC;
import Classes.Interfaces.LieuAtterrisage;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author scra
 */
public class Ciel extends Thread {

    public static boolean running = true;
    LieuAtterrisage aterrisage; // Permet d'utiliser l'interface LieuAtterriasage et ses méthodes

    public Ciel(LieuAtterrisage lieu) {
        aterrisage = lieu;
    }
    
    
    @Override
    public void run() {
        String nom = AvionTypeA.class.getName();
        Class cl;
        Object o;
        Constructor constr;
        Method me;
        Integer av;

        while (running) {
            try {
                Thread.sleep(100);
                if (nom.equals(AvionTypeB.class.getName())) {
                    nom = AvionTypeA.class.getName();
                } else if (nom.equals(AvionTypeC.class.getName())) {
                    nom = AvionTypeB.class.getName();
                } else {
                    nom = AvionTypeC.class.getName();
                }
                //On crée un objet Class
                cl = Class.forName(nom);
                // constructor 
                constr = cl.getConstructor();
                //Nouvelle instance de la classe Avion
                o = constr.newInstance();
                
                aterrisage.survoler((Avion) o);
                // Pause 3 secondes 
                Thread.sleep(6000);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ciel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Ciel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Ciel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
