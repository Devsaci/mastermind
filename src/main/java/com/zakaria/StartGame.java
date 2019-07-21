package com.zakaria;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * <b>Class de depart du Game</b>
 * Methode principal choicGameAndParameters ()
 * appel deux methode secondaire
 * 1 - selectParametres();
 * 2 - selectModeGame();
 *
 * @see Main
 */
public class StartGame {


    public static final Logger LOGGER = LogManager.getLogger();
    private static Scanner clavier = new Scanner(System.in);
    private static Scanner clavier1 = new Scanner(System.in);
    /**
     * Attribues  private
     *
     * @param nombEssais;
     * @param taille;
     * @param modeDeveloppeur;
     */
    private int modeGame;
    private int nombEssais;
    private int taille;
    private int modeDeveloppeur;

    /**
     * Getters and Setters
     *
     * @param: int modeGame;
     * int nombEssais;
     * int taille;
     * int  modeDeveloppeur;
     */
    public int getModeGame () {
        return modeGame;
    }

    public void setModeGame (int modeGame) {
        this.modeGame = modeGame;
    }

    public int getNombEssais () {
        return nombEssais;
    }

    public void setNombEssais (int nombEssais) {
        this.nombEssais = nombEssais;
    }

    public int getTaille () {
        return taille;
    }

    public void setTaille (int taille) {
        this.taille = taille;
    }


    /**
     * Constructeur par defaut
     * Attribue configurable dans
     * resources\config.properties
     *
     * @param: taille, nombEssais
     */
    public StartGame () {
        GameGetPropertyValues config = new GameGetPropertyValues();
        this.taille = Integer.parseInt(config.getPropValues().getProperty("taille"));
        this.nombEssais = Integer.parseInt(config.getPropValues().getProperty("nombEssais"));
        this.modeDeveloppeur = Integer.parseInt(config.getPropValues().getProperty("modeDeveloppeur"));
    }

    /**
     * Constructeur StartGame Test de fonction
     * dans src\main\java\com\zakaria\DriverTest.java
     * Attribue Saisi clavier
     *
     * @param : taille nombEssai modeGame
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public StartGame (int modeGame, int taille, int nombEssais) {
        this.modeGame = modeGame;
        this.taille = taille;
        this.nombEssais = nombEssais;
    }

    /**
     * Metthode selection
     * appeler dans DriverTest
     * 1 - Game_Mode_Challenger Class GameModeChallenger
     * /src\main\java\com\zakaria\GameModeChallenger.java
     * 2 - Game_Mode_Defenseur Class GameModeDefenseur
     * \src\main\java\com\zakaria\GameModeDefenseur.java
     * 3 - Game_Mode_Duel Class GameModeDuel
     * \src\main\java\com\zakaria\GameModeDuel.java
     * définie par utilisateur
     * 1 - Joueur donne combinaison GameModeDefenseur
     * 2 - Ordinateur donne combinaison GameModeChallenger
     * 3 - Alterne Joueur / Ordinateur
     *
     * @param : modeGame
     */


    public void selectModeGameDefault () {
        setModeGame(modeGame);
        switch (modeGame) {
            case 1:
                System.out.println("\n 1 - Game_Mode_Challenger...........START");
                new GameModeChallenger().runModeChallenger();
                break;
            case 2:
                System.out.println("\n 2 - Game_Mode_Defenseur............START");
                new GameModeDefenseur().runModeDefenseur();
                break;
            case 3:
                System.out.println("\n 3 - Game_Mode_Duel.................START");
                new GameModeDuel().runModeDuel();
                break;
        }
    }

    /**
     * Methode d'appel des methodes utilisé dans DriverTest
     * 1 - selectParametres()
     * 2 - selectModeGame();
     * 3 - reprise du Jeu
     */
    public void choicGameAndParametersDefault () {
        while (true) {
            selectModeGameDefault();
            System.out.println("\n" + "Voulez-vous recommencer (oui = Touche CLAVIER / non = 0)  : ");
            String repeat = clavier.nextLine();
            if (repeat.equalsIgnoreCase("0")) {
                System.out.println("...........THE END............");
                break;
            }
        }
        System.out.print("Au revoir");
    }

    /**
     * Methode d'appel des methodes utilisé dans  Main
     * 1 - selectParametres()
     * 2 - selectModeGame();
     * 3 - reprise du Jeu
     */
    public void choicGameAndParameters () {
        while (true) {
            selectParametres();
            selectModeGame();
            System.out.print("\n" + "Voulez-vous recommencer (oui = Touche CLAVIER / non = 0)  : ");
            String repeat = clavier.nextLine();
            if (repeat.equalsIgnoreCase("0")) {
                System.out.println("...........THE END............");
                break;
            }
        }
        System.out.print("Au revoir");
    }

    /**
     * Methode de selection des parametres dans
     * File config.properties
     *
     * @param: taille combinaison nombEssais Mode Devellopeur
     */
    public void selectParametres () {
        System.out.println(".................Choice Parameters ................." +
                "\n                 File config.properties ");
        GameGetPropertyValues config = new GameGetPropertyValues();
        this.taille = Integer.parseInt(config.getPropValues().getProperty("taille"));
        System.out.println("Taille Combinaison " + this.taille);
        this.nombEssais = Integer.parseInt(config.getPropValues().getProperty("nombEssais"));
        System.out.println("Nombres d'Essais " + this.nombEssais);
        this.modeDeveloppeur = Integer.parseInt(config.getPropValues().getProperty("modeDeveloppeur"));
        System.out.println("modeDeveloppeur " + this.modeDeveloppeur);
        if (modeDeveloppeur == 1)
            System.out.println("Combinaison secrete Visible");
        else
            System.out.println("Combinaison secrete Invisible");

        System.out.print("\n.................Choice Game :................." +
                "\n 1 - Game_Mode_Challenger" +
                "\n 2 - Game_Mode_Defenseur" +
                "\n 3 - Game_Mode_Duel \n ");
        LOGGER.error("\nError Message Logged !!! Entrez une valeur de 1 à 3");
        setModeGame(modeGame);
        try {
            modeGame = Integer.parseInt(clavier1.nextLine());
            //modeGame = clavier1.nextInt();
        }catch (NumberFormatException exception ){
            System.err.println( "Entrez une valeur de 1 à 3" );
        }

    }

    /**
     * Metthode selection appeler dans Main
     * 1 - Game_Mode_Challenger Class GameModeChallenger
     * /src\main\java\com\zakaria\GameModeChallenger.java
     * 2 - Game_Mode_Defenseur Class GameModeDefenseur
     * \src\main\java\com\zakaria\GameModeDefenseur.java
     * 3 - Game_Mode_Duel Class GameModeDuel
     * \src\main\java\com\zakaria\GameModeDuel.java
     * <p>
     * modeGame définie par utilisateur
     * 1 - Joueur donne combinaison GameModeDefenseur
     * 2 - Ordinateur donne combinaison GameModeChallenger
     * 3 - Alterne Joueur / Ordinateur
     */

    public void selectModeGame () {
        setModeGame(modeGame);
        switch (modeGame) {
            case 1:
                System.out.print("\n 1 - Game_Mode_Challenger...........START");
                new GameModeChallenger(taille, nombEssais).runModeChallenger();
                break;
            case 2:
                System.out.print("\n 2 - Game_Mode_Defenseur............START");
                new GameModeDefenseur(taille, nombEssais).runModeDefenseur();
                break;
            case 3:
                System.out.print("\n 3 - Game_Mode_Duel.................START");
                new GameModeDuel(taille, nombEssais).runModeDuel();
                break;
        }
    }


}



