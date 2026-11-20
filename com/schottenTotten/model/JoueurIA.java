package com.schottenTotten.model;

import java.util.ArrayList;
import java.util.Random;

public class JoueurIA extends Joueur {
    private final Random hasard = new Random();

    public JoueurIA(String nom) {
        super(nom);
    }

    @Override
    public Coup decider(Borne[] bornes) {
        ArrayList<Integer> jouables = new ArrayList<>();
        for (int i = 0; i < bornes.length; i++) {
            if (!bornes[i].estRevendiquee() && !bornes[i].estCompletPour(this)) {
                jouables.add(i + 1);
            }
        }
        if (jouables.isEmpty()) {
            throw new IllegalStateException("Aucune borne jouable");
        }
        int carte = hasard.nextInt(nbCartes()) + 1;
        int borne = jouables.get(hasard.nextInt(jouables.size()));
        return new Coup(carte, borne);
    }
}