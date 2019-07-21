package com.zakaria;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * public class  GameModeChallenger
 * Joueur donne combinaison
 */
public class GameModeChallenger {
    public static final Logger LOGGER = LogManager.getLogger();
    /**
     * Attribue
     * private int nombEssais ;
     * private int taille;
     */
    private int nombEssais;
    private int taille;
    private int modeDeveloppeur;

    public int getModeDeveloppeur () {
        return modeDeveloppeur;
    }

    public void setModeDeveloppeur (int modeDeveloppeur) {
        this.modeDeveloppeur = modeDeveloppeur;
    }

    /**
     * Getters getTaille
     */
    public int getTaille () {
        return taille;
    }

    /**
     * Setters setTaille
     */
    public void setTaille (int taille) {
        this.taille = taille;
    }

    /**
     * Getters getNombEssais
     */
    public int getNombEssais () {
        return nombEssais;
    }

    /**
     * Setters setNombEssais
     */
    public void setNombEssais (int nombEssais) {
        this.nombEssais = nombEssais;
    }

    /**
     * Constructeur GameModeChallenger
     * Parametre configuré dans File config.properties
     */
    public GameModeChallenger () {
        GameGetPropertyValues config = new GameGetPropertyValues();
        this.taille = Integer.parseInt(config.getPropValues().getProperty("taille"));
        this.nombEssais = Integer.parseInt(config.getPropValues().getProperty("nombEssais"));
        this.modeDeveloppeur = Integer.parseInt(config.getPropValues().getProperty("modeDeveloppeur"));
    }

    /**
     * Constructeur GameModeChallenger
     * Parametre configuré dans DriverTest this.setTaille(4);
     *
     * @param nombEssais nombre d'Essais possible saissie Clavier dans Class DriverTest
     */
    public GameModeChallenger (int nombEssais) {
        this.setTaille(4);
        this.nombEssais = nombEssais;
    }

    /**
     * Constructeur GameModeChallenger (int taille,int nombEssais)
     * Parametre configuré dans DriverTest
     *
     * @param taille
     * @param nombEssais
     */
    public GameModeChallenger (int taille, int nombEssais) {
        GameGetPropertyValues config = new GameGetPropertyValues();
        this.taille = Integer.parseInt(config.getPropValues().getProperty("taille"));
        this.nombEssais = Integer.parseInt(config.getPropValues().getProperty("nombEssais"));
        this.modeDeveloppeur = Integer.parseInt(config.getPropValues().getProperty("modeDeveloppeur"));
    }

    /**
     * public String compareModeChallenger (CombinaisonOrdinateur c, CombinaisonJoueur cE)
     *
     * @return : result
     * @param: CombinaisonOrdinateur, CombinaisonJoueur
     */
    private String compareModeChallenger (CombinaisonOrdinateur c, CombinaisonJoueur cE) {
        //123==324 CombinaisonOrdinateur c Vs CombinaisonEnt cE
        setTaille(taille);
        String result = "";
        for (int i = 0; i < taille; i++) {
            int gauche = Character.getNumericValue(c.getNbre().charAt(i));
            int droite = Character.getNumericValue(cE.getNbre().charAt(i));
            if (gauche > droite) {
                result = result + "+";
            } else if (gauche < droite) {
                result = result + "-";
            } else {
                result = result + "=";
            }
        }
        return result;
    }


    /**
     * public void runModeChallenger/
     * Ordinateur donne Combinaison
     * Loop (Joueur donne Combinaison)
     */
    public void runModeChallenger () {

        setTaille(taille);
        setNombEssais(nombEssais);
        setModeDeveloppeur(modeDeveloppeur);
        int tours = 0;
        System.out.println("\n___________Ordinateur donne Combinaison___________________");
        CombinaisonOrdinateur c = new CombinaisonOrdinateur(modeDeveloppeur, taille);
        c.generate(0, 9);
        c.display();

        boolean gagner = false;
        do {
            System.out.println("\n_____________Joueur donne Combinaison_______________________");
            CombinaisonJoueur cE = new CombinaisonJoueur(taille);
            cE.generate();
            cE.displayAll();
            compareModeChallenger(c, cE);
            System.out.println("Score                            " + compareModeChallenger(c, cE));
            String[] nbre = compareModeChallenger(c, cE).split("");
            gagner = true;
            for (int i = 0; i < taille; ++i) {
                if (!nbre[i].equals("=")) {
                    gagner = false;
                }
            }
            tours++;
        } while (gagner == false && tours < getNombEssais());

        int scoreModeChallengerCompt = 0;
        if (gagner == true) {
            ++scoreModeChallengerCompt;
            System.out.println("\n ####  Gagné ....Votre score  " + scoreModeChallengerCompt + "/" + tours + "  #######");

        } else {

            System.out.println("\n####....Fin des Essais........Votre score  " + scoreModeChallengerCompt + "/" + tours + "  #######");
            c.displayAll();
        }

        System.out.println("\n");
        System.out.println("\nFin  runModeChallenger");

    }
}

