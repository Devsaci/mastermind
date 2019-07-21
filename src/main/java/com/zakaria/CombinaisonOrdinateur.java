package com.zakaria;

import java.util.Random;

/**
 * Class CombinaisonOrdinateur extends Combinaison
 */
public class CombinaisonOrdinateur extends Combinaison {
    /**
     * Constructeur
     *
     * @param modeDeveloppeur mode param
     * @param taille          Instancie  combinaison Ordinateur en Mode developpeur
     */
    public CombinaisonOrdinateur (int modeDeveloppeur, int taille) {
        super(taille);
        GameGetPropertyValues config = new GameGetPropertyValues();
        this.modeDeveloppeur = Integer.parseInt(config.getPropValues().getProperty("modeDeveloppeur"));
    }

    public CombinaisonOrdinateur (int taille) {
        super(taille);
    }

    @Override
    public String generate (int min, int max) {
        this.nbre = "";
        Random rd = new Random();
        for (int i = 0; i < taille; i++) {
            String unChiffre = String.valueOf(rd.nextInt(max - min) + min);
            this.nbre = this.nbre + unChiffre;
        }
        return nbre;
    }


    @Override
    public void display () {
        if (modeDeveloppeur == 1) {
            System.out.println("Le combinaison Ordinateur est XXXX  " + nbre);
        } else {
            System.out.println("Le combinaison Ordinateur est  XXXX");
        }
    }

    public void displayAll () {
        System.out.println("La combinaison Ordinateur est    " + nbre);
    }

    @Override
    public void startOrdinateur () {
        System.out.println("Ordinateur donne combinaison ");
        this.generate(0, 9);
        this.displayAll();
    }

    public String generateNewCombinaison (String result , CombinaisonOrdinateur c) {
         String[] nbrescore = result.split("");
        String generateNewCombinaison = null;
        for (int i = 0; i < taille; i++) {
            Random rd = new Random();


            if (nbrescore[i].equals("+")) {
               //String unChiffre = String.valueOf(rd.nextInt(( (9) - c.getNbre().charAt(i))+1 ) + c.getNbre().charAt(i));
                String unChiffre = String.valueOf(rd.nextInt(( (c.getNbre().charAt(i)+3) - c.getNbre().charAt(i))+1 ) + c.getNbre().charAt(i));
                generateNewCombinaison = this.nbre + unChiffre;
            } else if (nbrescore[i].equals("-")) {
               // String unChiffre = String.valueOf(rd.nextInt((c.getNbre().charAt(i) - 0)+1)+0);
                String unChiffre = String.valueOf(rd.nextInt((c.getNbre().charAt(i) - 1)+1)+1);
                generateNewCombinaison = this.nbre + unChiffre;
            }
            else if (nbrescore[i].equals("=")){
                generateNewCombinaison = this.nbre;
            }
        }
        return generateNewCombinaison;
    }

}
