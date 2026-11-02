package com.schottenTotten.model;

public class Carte {
    private final int valeur;
    private final CouleurCarte couleur;

    public Carte(CouleurCarte couleur, int valeur) {

        if (valeur > 9 || valeur < 1) {
            throw new IllegalArgumentException("Le chiffre n'est pas valide");
        }
        if (couleur == null){
            throw new IllegalArgumentException("La couleur ne peut pas être null");
        }
        this.valeur = valeur;
        this.couleur = couleur;
    }
    // pas besoin d'un constructeur sans paramètre

    public int getValeur() // pour plus tard gérer les combinaisons
    {
        return this.valeur;
    }

    public CouleurCarte getCouleur() // pour plus tard gérer les combinaisons
    {
        return this.couleur;
    }

    @Override
    public String toString() {
        return this.valeur + " " + ":" + " " + this.couleur;
    }

    public static void main(String[] args) {

        try {
            Carte carte = new Carte(null, 4);
            System.out.println("votre carte est : " + carte.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Refusé : " + e.getMessage());
        }
    }
}
