package com.schottenTotten.model;

public class Coup {
    private final int carte;   // indice dans la main de 1 à nbCartes
    private final int borne;   // indice de la borne de 1 à 9

    public Coup(int carte, int borne) {
        if (carte < 1 || borne < 1) {
            throw new IllegalArgumentException("Les indices commencent à 1");
        }
        this.carte = carte;
        this.borne = borne;
    }

    public int getCarte() { return carte; }
    public int getBorne() { return borne; }
}