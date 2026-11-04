package com.schottenTotten;

import com.schottenTotten.model.*;

public class Main {
    public static void main(String[] args) {
        Pioche pioche = new Pioche();
        System.out.println("Taille : " + pioche.taille());   // attendu : 54

        for (int i = 1; i < 7; i ++){
            System.out.println("Voici votre jeu : " + pioche.piocher());
        }
        System.out.println("Taille : " + pioche.taille());   // attendu : 48

        for (int i = 1; i < 49; i ++){
            pioche.piocher();
        }
        try {
            pioche.piocher();
        } catch (IllegalStateException e) {
            System.out.println("Impossible : " + e.getMessage());
        }
    }
}

