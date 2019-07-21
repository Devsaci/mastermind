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
        this.nbre = "";
        for (int i = 0; i < taille; i++) {
            Random rd = new Random();


            if (nbrescore[i].equals("+")) {
                String unChiffre = String.valueOf(getRandomNumberInRange(Character.getNumericValue(c.getNbre().charAt(i)) + 1, 9));
                this.nbre = this.nbre + unChiffre;
            } else if (nbrescore[i].equals("-")) {
                String unChiffre = String.valueOf(getRandomNumberInRange(1, Character.getNumericValue(c.getNbre().charAt(i)) - 1));
                this.nbre = this.nbre + unChiffre;
            }
            else if (nbrescore[i].equals("=")){
                this.nbre = this.nbre + c.getNbre().charAt(i);
            }
        }
        return this.nbre;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}
