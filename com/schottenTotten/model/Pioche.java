package com.schottenTotten.model;

import java.util.*;

public class Pioche {
    private final ArrayList<Carte> pioche;

    public Pioche() {
        this.pioche = new ArrayList<>();
        for (CouleurCarte c : CouleurCarte.values()) {
            for (int i = 1; i < 10; i++) {
                Carte carte = new Carte(i, c);
                pioche.add(carte);
            }
        }
        Collections.shuffle(pioche);
    }

    public Carte piocher() {
        if (estVide()) {
            throw new IllegalStateException("Vous ne pouvez plus piocher.");
        }
        return pioche.remove(pioche.size() - 1);
    }

    public boolean estVide() {
        return pioche.isEmpty();
    }

    public int taille() {
        return pioche.size();
    }
}



