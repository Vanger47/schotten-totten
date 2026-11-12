package com.schottenTotten.model;

import java.util.ArrayList;

public class Combinaison implements Comparable<Combinaison> {
    private final int somme;
    private final TypeCombinaison combinaison;
    private final ArrayList<Carte> cartes;

    public Combinaison(ArrayList<Carte> cartes) {
        this.cartes = new ArrayList<>(cartes);
        this.somme = sommer(this.cartes);
        this.combinaison = trouverCombinaison(this.cartes);
    }

    private int sommer(ArrayList<Carte> cartes) {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            Carte tmp = cartes.get(i);
            total += tmp.getValeur();
        }
        return total;
    }

    private TypeCombinaison trouverCombinaison(ArrayList<Carte> cartes) {
        cartes.sort((a, b) -> Integer.compare(a.getValeur(), b.getValeur()));
        int tot_couleur = 1;
        int tot_suite = 1;
        int tot_brelan = 1;
        boolean meme_couleur = false;
        boolean suite = false;
        boolean brelan = false;
        int nombre = 0;
        CouleurCarte couleurcarte = null;
        for (int i = 0; i < 3; i++) {
            Carte tmp = cartes.get(i);
            CouleurCarte couleur_tmp = tmp.getCouleur();
            int nombre_tmp = tmp.getValeur();
            if (i == 0) {
                couleurcarte = couleur_tmp;
                nombre = nombre_tmp;
            } else {
                if (couleurcarte == couleur_tmp) {
                    tot_couleur++;
                }
                if ((i == 1 && nombre == nombre_tmp - 1) || (i == 2 && nombre == nombre_tmp - 2)) {
                    tot_suite++;
                }
                if (nombre == nombre_tmp) {
                    tot_brelan++;
                }
            }
        }
        if (tot_couleur == 3) {
            meme_couleur = true;
        }
        if (tot_suite == 3) {
            suite = true;
        }
        if (tot_brelan == 3) {
            brelan = true;
        }

        if (meme_couleur && suite) {
            return TypeCombinaison.SUITECOULEUR;
        } else if (meme_couleur && !suite) {
            return TypeCombinaison.COULEUR;
        } else if (suite && !meme_couleur) {
            return TypeCombinaison.SUITE;
        } else if (brelan) {
            return TypeCombinaison.BRELAN;
        } else {
            return TypeCombinaison.SOMME;
        }
    }

    @Override
    public int compareTo(Combinaison autre) {
        int resultat = this.combinaison.compareTo(autre.combinaison); //méthode d'objet. On aurait pu utilsier compare en rajoutant .ordinal()
        if (resultat != 0) {
            return resultat;
        }
        return Integer.compare(this.somme, autre.somme); //méthode statique on lui passe les deux param
    }
}