package com.zakaria;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Class  mère dont hérite Class CombinaisonOrdinateur et
 * classs CombinaisonJoueur
 */

public class Combinaison {
    public static final Logger LOGGER = LogManager.getLogger();
    /**
     * Attribues en protected
     */

    protected String nbre = "";
    protected int taille;
    protected int modeDeveloppeur;

    public int getModeDeveloppeur () {
        return modeDeveloppeur;
    }

    public void setModeDeveloppeur (int modeDeveloppeur) {
        this.modeDeveloppeur = modeDeveloppeur;
    }

    /**
     * Getters et Setters
     *
     * @return nbre chiffre Saissi Clavier
     */
    public String getNbre () {
        return nbre;
    }


    public void setNbre (String nbre) {
        if (nbre.length() != taille)
            throw new IllegalArgumentException("taille combinaison invalide");
        this.nbre = nbre;
}


    public int getTaille () {
        return taille;
    }

    /**
     * @param taille Taille combinaison saissi clavier
     *               dans Class DriverTest
     */
    public void setTaille (int taille) {

        if ((taille < 0 || taille > 9)) {
            if (taille < 0 || taille > 9) {
                LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
                throw new NullPointerException(" Entrez une chiffre entre  0 et 9");
            }
        }
        this.taille = taille;
    }

    /**
     * Constructeur par defaut
     */

    public Combinaison () {
        this.setTaille(4);
    }

    /**
     * Constructeur
     * Combinaison (int taille)
     *
     * @param taille taillle de combinaison
     */
    public Combinaison (int taille) {
        this.setTaille(taille);
    }

    /**
     * Methode public void display ()
     */
    public void display () {
    }

    public String generate (int min, int max) {
        return nbre;
    }

    public String generate () {
        return nbre;
    }

    public void startOrdinateur () {
    }

    public void startJoueur () {
    }

}
