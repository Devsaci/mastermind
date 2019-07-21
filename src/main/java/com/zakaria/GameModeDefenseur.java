package com.zakaria;

import java.util.Random;

/**
 * Class GameModeDefenseur
 * Le joueur donne Combinaison et l'ordinateur devine
 */

public class GameModeDefenseur {
    /**
     * attribues en private
     */
    private int nombEssais;
    private int taille;
    private int modeDeveloppeur;
    private String nbre;

    /**
     * Getters ans Setters
     * nombEssais;
     * aille;
     * modeDeveloppeur;
     */
    public int getTaille () {
        return taille;
    }

    public void setTaille (int taille) {
        this.taille = taille;
    }

    public int getNombEssais () {
        return nombEssais;
    }

    public void setNombEssais (int nombEssais) {
        this.nombEssais = nombEssais;
    }

    public void setModeDeveloppeur (int modeDeveloppeur) {
        this.modeDeveloppeur = modeDeveloppeur;
    }

    /**
     * Constructeur GameModeDefenseur
     * implemente les parametres
     * getProperty("taille")
     * getProperty("nombEssais")
     * de File config.properties
     */
    public GameModeDefenseur () {
        GameGetPropertyValues config = new GameGetPropertyValues();
        this.taille = Integer.parseInt(config.getPropValues().getProperty("taille"));
        this.nombEssais = Integer.parseInt(config.getPropValues().getProperty("nombEssais"));
    }

    /**
     * Constructeur GameModeDefenseur
     * implemente les parametres int nombEssais Class DriverTest
     */
    public GameModeDefenseur (int nombEssais) {
        this.setNombEssais(nombEssais);
    }

    /**
     * Constructeur GameModeDefenseur
     * implemente les parametres (int taille, int nombEssais) de Class DriverTest
     */
    public GameModeDefenseur (int taille, int nombEssais) {
        this.setTaille(taille);
        this.setNombEssais(nombEssais);
    }

    /**
     * comparetModeDefenseur (CombinaisonJoueur cE, CombinaisonOrdinateur c)
     * return String result +..-..= ..
     */
    private String comparetModeDefenseur (CombinaisonJoueur cE, CombinaisonOrdinateur c) {
        //CombinaisonJoueur cE Vs CombinaisonOrdinateur c
        String result = "";
        for (int i = 0; i < taille; i++) {
            int gauche = Character.getNumericValue(cE.getNbre().charAt(i));
            int droite = Character.getNumericValue(c.getNbre().charAt(i));
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
     * runModeDefenseur ()
     * instancie Combinaison Joueur (CE)
     * genere et laffiche Combinaison Joueur  en mode non developpeur
     * instancie Combinaison Ordinateur(C)
     * genere et affiche Combinaison Ordinateur  en mode developpeur
     * runModeDefenseur () compare CE/C
     * do..While :
     * //la boucle do....while tourne tans que :
     * // 1 - la variable gagner = false
     * // 2 - tours < NombEssais
     * Si gagner = true on affiche ####  Gagné ....Votre score et Fin  runModeDefenseur
     * Sinon ####....Fin des Essais
     */

    public void runModeDefenseur () {
        setTaille(taille);
        setNombEssais(nombEssais);
        setModeDeveloppeur(modeDeveloppeur);
        int tours = 0;
        System.out.println("\n_____________Joueur donne combinaison_______________________");
        CombinaisonJoueur cE = new CombinaisonJoueur(modeDeveloppeur, taille);
        cE.generate();
        cE.display();
        boolean gagner = false;

        String resultat = "";
        CombinaisonOrdinateur combinaisonOrdinateur = null;
        do {

            System.out.println("\n_____________Ordinateur donne Combinaison_______________________");

            if (tours == 0) {
                combinaisonOrdinateur = new CombinaisonOrdinateur(taille);
                combinaisonOrdinateur.generate(0, 9);
            } else {
                CombinaisonOrdinateur newCombinaison = new CombinaisonOrdinateur(taille);
                newCombinaison.generateNewCombinaison(resultat, combinaisonOrdinateur);
                combinaisonOrdinateur = newCombinaison;
            }
            combinaisonOrdinateur.displayAll();
            resultat = comparetModeDefenseur(cE, combinaisonOrdinateur);
            System.out.println("Score                            " + resultat);

            String [] nbrescore = resultat.split("");
            gagner = true;
            for (int i = 0; i < taille; ++i) {
                if (!nbrescore[i].equals("=")) {
                    gagner = false;
                    // variable gagner = false si result = " ==== "
                }
            }


            tours++;
            //la boucle do....while tourne tans que :
            // 1 - la variable gagner = false
            // 2 - tours < NombEssais
        } while (gagner == false && tours < getNombEssais());
        int scoreModeDefenseurCompt = 0;
        // Si gagner = true on affiche ####  Gagné ....Votre score et Fin  runModeDefenseur
        //Sinon ####....Fin des Essais
        if (gagner == true) {
            scoreModeDefenseurCompt++;
            System.out.print("\n ####  Gagné ....Votre score  " + scoreModeDefenseurCompt + "/" + tours + "  #######");
        } else {
            System.out.print("\n####....Fin des Essais........Votre score  " + scoreModeDefenseurCompt + "/" + tours + "  #######");
            cE.displayAll();
        }
        System.out.println("\n");
        System.out.println("\nFin  runModeDefenseur");

    }
}
