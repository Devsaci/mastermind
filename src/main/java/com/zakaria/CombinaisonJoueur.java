package com.zakaria;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Public class CombinaisonJoueur extends Combinaison
 * Generer combinaison Joueur saisi clavier
 */
public class CombinaisonJoueur extends Combinaison {
    private static final Logger LOGGER = LogManager.getLogger();
    public static Scanner clavier = new Scanner(System.in);

    /**
     * Constructeur
     *
     * @param taille
     */
    public CombinaisonJoueur (int taille) {
        super(taille);
    }

    /**
     * Constructeur
     *
     * @param modeDeveloppeur
     * @param taille          Instancie  Combinaison Joueur  en Mode developpeur
     */

    public CombinaisonJoueur (int modeDeveloppeur, int taille) {
        super(taille);
        GameGetPropertyValues config = new GameGetPropertyValues();
        this.modeDeveloppeur = Integer.parseInt(config.getPropValues().getProperty("modeDeveloppeur"));
    }

    @Override
    public String generate () {
        this.nbre = "";
        Scanner clavier = new Scanner(System.in);
        int tryMaxCount = 3;
        while (tryMaxCount > 0) {
            try {
                LOGGER.error("\nError Message Logged !!! Entrez une valeur de 0 à 9");
                nbre = String.valueOf(Integer.parseInt(clavier.nextLine()));
                setNbre(nbre);
                break;// Pour sortir de la boucle while
            } catch (NumberFormatException e) {
                System.err.println("La chaîne n'est pas un entier");
            } catch (IllegalArgumentException e) {
                System.err.println("taille combinaison invalide");
            }
            tryMaxCount--;  // On réduit le nombre de tentatives restantes.
            if (tryMaxCount == 0) {
                System.out.print("\n" + "Voulez-vous recommencer (oui = Touche CLAVIER / non = 0)  : ");
                String repeat = clavier.nextLine();
                if (repeat.equalsIgnoreCase("0")) {
                    System.out.println("...........THE END............");
                    System.exit(1);
                } else {
                    new StartGame().choicGameAndParameters();
                }
            }
        }
        return nbre;
    }

    @Override
    public void display () {
        if (modeDeveloppeur == 1)
            System.out.println("La combinaison Joueur est    XXXX    " + nbre);
        else
            System.out.println(" La combinaison Joueur est  XXXX   ");
    }

    public void displayAll () {
        System.out.println("\nLa combinaison Joueur est        " + nbre);
    }


    @Override
    public void startJoueur () {
        System.out.println("Joueur donne combinaison ");
        this.generate();
        this.displayAll();
    }


}
