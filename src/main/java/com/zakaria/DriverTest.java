package com.zakaria;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Scanner;
/**
 * Class de Test Manuel
 * Test Class Combinaison Ordinateur......
 * Test Class Combinaison Joueur.......
 * Test  Class Game Mode  Challenger.......
 * Test Method compareModeChallenger(cO,cJ)......
 * Test  Class GameModeChallenger(6, 6) MethoderunModeChallenger()...
 * Test Class Game Mode Defenseur......
 * Test Method  comparetModeDefenseur(cJ, cO)....
 * Test Method  runModeDefenseur()........
 * Test Class Game Mode Duel......
 * Test runModeDuel()......
 * Test Class Start choicGame......
 * Game_Class Mode_Duel
 * Game_Class Mode_Defenseur
 * Game_Class Mode_Challenger*
 */
public class DriverTest {

    public static Scanner clavier = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger();
    private static String nbre = "";
    private static int modeGame;
    private static int taille;
    private static int nombEssais;

    public static String getNbre () {
        return nbre;
    }

    public static void setNbre (String nbre) {
        DriverTest.nbre = nbre;
    }

    public static int getModeGame () {
        return modeGame;
    }

    public static void setModeGame (int modeGame) {
        DriverTest.modeGame = modeGame;
    }

    public static int getTaille () {
        return taille;
    }

    public static void setTaille (int taille) {

        if (taille < 0 || taille > 9) {
            throw new NullPointerException(" Entrez une chiffre entre  0 et 9");
        }
        DriverTest.taille = taille;
    }

    public static int getNombEssais () {
        return nombEssais;
    }

    public static void setNombEssais (int nombEssais) {
        DriverTest.nombEssais = nombEssais;
    }


    private  static void saisieTaille () {
        System.out.println("..............Entrer taille....................");
        setTaille(taille);
        taille = clavier.nextInt();
    }

    private  static void saisienombEssais () {
        System.out.println("............Entrer nombEssais.................");
        setNombEssais(nombEssais);
        nombEssais = clavier.nextInt();
    }

    private  static void saisiemodeGame () {
        System.out.println("..............Entrer ModeGame...................");
        setModeGame(modeGame);
        modeGame = clavier.nextInt();
    }


    public static void main (String[] args) {
        LOGGER.info("démarage de mastermind");


/**....Test Combinaison Ordinateur........*/
//        System.out.println("..............CombinaisonOrdinateur.................");
//        saisieTaille();
//        setTaille(taille);
//        new CombinaisonOrdinateur(taille).startOrdinateur();

/**....Test Combinaison Joueur........*/
//        System.out.println(".................CombinaisonJoueur...............");
//        new CombinaisonJoueur(taille).startJoueur();
//        saisieTaille ();
//        setTaille(taille);
//        new CombinaisonJoueur(taille).startJoueur();


/**....Test  Game Mode  Challenger........*/
/**....Test compareModeChallenger(cO,cJ)........*/
//        CombinaisonOrdinateur cO = new CombinaisonOrdinateur();
//        cO.startOrdinateur();
//        CombinaisonJoueur cJ = new CombinaisonJoueur();
//        cJ.startJoueur();
//        saisieTaille ();
//        CombinaisonOrdinateur cO = new CombinaisonOrdinateur(taille);
//        cO.startOrdinateur();
//        CombinaisonJoueur cJ = new CombinaisonJoueur(taille);
//        cJ.startJoueur();
//        String rest = new GameModeChallenger(taille,nombEssais).compareModeChallenger(cO, cJ);
//        System.out.println(rest);
/**....Test GameModeChallenger(6, 6).runModeChallenger()..........*/
//        GameModeChallenger jou = new GameModeChallenger();
//        new GameModeChallenger().runModeChallenger();
//        new GameModeChallenger(5).runModeChallenger();
//        saisieTaille();
//        saisienombEssais();
//        new GameModeChallenger(taille, nombEssais).runModeChallenger();


/**....Test Game Mode Defenseur........*/
        /**....Test comparetModeDefenseur(cJ, cO)........*/
//        CombinaisonJoueur cJ = new CombinaisonJoueur();
//        cJ.startJoueur();
//        CombinaisonOrdinateur cO = new CombinaisonOrdinateur();
//        cO.startOrdinateur();
//        saisieTaille();
//        CombinaisonJoueur cJ = new CombinaisonJoueur(taille);
//        cJ.startJoueur();
//        CombinaisonOrdinateur cO = new CombinaisonOrdinateur(taille);
//        cO.startOrdinateur();
//       String result = new GameModeDefenseur(taille,nombEssais).comparetModeDefenseur(cJ, cO);
//        System.out.println(result);
        /**....Test runModeDefenseur()..........*/
 //       GameModeDefenseur jou = new GameModeDefenseur();
 //       new GameModeDefenseur().runModeDefenseur();
//        new GameModeDefenseur(5).runModeDefenseur();
//        saisieTaille();
//        saisienombEssais();
//        new GameModeDefenseur(taille, nombEssais).runModeDefenseur();


        /**....Test Game Mode Duel........*/
        /**....Test runModeDuel()........*/
//        GameModeDuel jou = new GameModeDuel();
//        new GameModeDuel().runModeDuel();
//        new GameModeDuel(6).runModeDuel();
//        saisieTaille();
//        saisienombEssais();
//        new GameModeDuel(taille, nombEssais).runModeDuel();


        /**....Test Start choicGame........*/

//        StartGame g2 = new StartGame(modeGame, taille, nombEssais);
//        g2.choicGameAndParameters();


        /** Game_Mode_Duel*/
//        StartGame g1 = new StartGame(3);
//        g1.choicGameAndParametersDefault();
        /** Game_Mode_Defenseur*/
//        StartGame g1 = new StartGame(2);
//        g1.choicGameAndParametersDefault();
        /** Game_Mode_Challenger*/
//        StartGame g1 = new StartGame(1);
//        g1.choicGameAndParametersDefault();

/**.#######################   Test Start Game  ####################*/
//    new StartGame(modeGame, taille, nombEssais).choicGameAndParametersDefault();


    }
}