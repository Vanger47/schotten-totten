package com.schottenTotten.model;

import java.util.*;

public abstract class Joueur {
    private final String nom;
    private ArrayList<Carte> main;

    public Joueur(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Nom incorrect");
        }
        this.nom = nom;
        this.main = new ArrayList<>();
    }

    public void recevoir(Carte carte) {
        if (carte == null) {
            throw new IllegalArgumentException("Carte invalide");
        }
        main.add(carte);
    }

    public Carte jouer(int indice) {
        if (indice <= 0 || indice > main.size()) {
            throw new IllegalArgumentException("La valeur de l'indice n'est pas valide");
        }
        return main.remove(indice - 1);
    }

    public String getNom() {
        return this.nom;
    }

    public ArrayList<Carte> getMain() {
        return new ArrayList<>(main); // pas oublier d'envoyer une copie
    }

    public int nbCartes() {
        return this.main.size();
    }
}