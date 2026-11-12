package com.schottenTotten.model;

import java.util.*;

public class Borne {

    private Joueur proprietaire;
    private ArrayList<Carte> cartes1;
    private ArrayList<Carte> cartes2;
    private Joueur joueur1;
    private Joueur joueur2;
    private int carteMax;
    private Joueur premier;

    private static final int CARTES_PAR_DEFAUT = 3;

    public Borne(Joueur j1, Joueur j2) {
        if (j1 == null || j2 == null) {
            throw new IllegalArgumentException("Le joueur doit être différent de null");
        }
        this.proprietaire = null;
        this.cartes1 = new ArrayList<>();
        this.cartes2 = new ArrayList<>();
        this.joueur1 = j1;
        this.joueur2 = j2;
        this.carteMax = CARTES_PAR_DEFAUT;
        this.premier = null;
    }

    public void poser(Joueur j, Carte carte) {
        if (carte == null) {
            throw new IllegalArgumentException("La carte n'existe pas");
        }
        if (j != joueur1 && j != joueur2) {
            throw new IllegalArgumentException("Le joueur est inconnu");
        }

        if (this.joueur1 == j) {
            if (cartes1.size() >= carteMax) {
                throw new IllegalStateException("Impossible : il y a déjà " + carteMax + " cartes");
            }
            cartes1.add(carte);
        } else {
            if (cartes2.size() >= carteMax) {
                throw new IllegalStateException("Impossible : il y a déjà " + carteMax + " cartes");
            }
            cartes2.add(carte);
        }
        if (cartes1.size() == carteMax || cartes2.size() == carteMax) {
            if (premier == null) {
                this.premier = j;
            }
        }
    }

    public boolean estRevendiquee() {
        return this.proprietaire != null;
    }

    public void revendiquer(Joueur j) {
        if (this.proprietaire != null) {
            throw new IllegalStateException("La borne a déjà été revendiquée");
        }
        if (j != joueur1 && j != joueur2) {
            throw new IllegalArgumentException("Le joueur est inconnu");
        }
        this.proprietaire = j;
    }

    public ArrayList<Carte> montrerCartes(Joueur j) {
        if (this.joueur1 == j) {
            return new ArrayList<>(cartes1);
        }
        if (this.joueur2 == j) {
            return new ArrayList<>(cartes2);
        }
        throw new IllegalArgumentException("Le joueur est inconnu");
    }

    public Joueur getPremier() {
        return this.premier;
    }

    public Joueur getProprietaire() {
        return this.proprietaire;
    }

    public Joueur getJoueur1() {
        return this.joueur1;
    }

    public Joueur getJoueur2() {
        return this.joueur2;
    }

    public boolean estComplet() {
        return (cartes1.size() == carteMax && cartes2.size() == carteMax);
    }

}
