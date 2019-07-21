package com.zakaria;


import java.util.Scanner;
/**
 * class GameModeDuel alterne entre mode chalenger et defenseur
 * trois Duel permis
 *
 *
 */

public class GameModeDuel {


    public static Scanner clavier = new Scanner(System.in);

    private int duel  =3;
    private int nombEssais;
    private int taille;

    /**
     * Getters Taille
     */
    public int getTaille () {
        return taille;
    }

    public int getNombEssais () {
        return nombEssais;
    }

    public void setTaille (int taille) {
        this.taille = taille;
    }

    public void setNombEssais (int nombEssais) {
        this.nombEssais = nombEssais;
    }


    /**
     * Constructeur mode Developpeur
     */

    public GameModeDuel () {
        GameGetPropertyValues config = new GameGetPropertyValues();
        this.taille = Integer.parseInt(config.getPropValues().getProperty("taille"));
        this.nombEssais = Integer.parseInt(config.getPropValues().getProperty("nombEssais"));
    }
    /**
     * Constructeur instancié  dans DriverTest
     * @param nombEssais*
     *
     */
    public GameModeDuel (int nombEssais) {
        this.nombEssais = nombEssais;
    }
    /**
     * Constructeur instancié  dans DriverTest
     * @param nombEssais
     * @param  taille
     *
     */
    public GameModeDuel (int taille, int nombEssais) {
        this.nombEssais = nombEssais;
        this.taille = taille;
    }

    /**
     * µMethode Altern entre Mode Chalenger et Mode Defenseur
     *
     */

    public void runModeDuel () {
        setTaille(taille);
        setNombEssais(nombEssais);
        System.out.println();
        System.out.println("\n Trois duel permis" +
                "\nQui commence à jouer  ? " +
                "\n 1 - Joueur GameModeDefenseur " +
                "\n 2 - Ordinateur GameModeChallenger ");
        String choix = clavier.nextLine();
        System.out.println("");
        int round = 1;
        do {
            switch (choix) {
                case "1":
                    new GameModeDefenseur(taille, nombEssais).runModeDefenseur();
                    break;
                case "2":
                    System.out.println(".......GameModeChallenge.............");
                    new GameModeChallenger(taille, nombEssais).runModeChallenger();
                    break;
            }
            System.out.println("\n");
            if (choix.equals("1")) {
                new GameModeChallenger(taille, nombEssais).runModeChallenger();
            } else {
                System.out.println("....GameModeDefenseur....................");
                new GameModeDefenseur(taille, nombEssais).runModeDefenseur();
            }
            System.out.printf("Fin Duel %d" ,round );
            round++;
        } while (round <= duel);


    }
}
