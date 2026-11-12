package com.schottenTotten.controller;

import com.schottenTotten.model.*;
import java.util.*;

// ici on pourrait soit l'implémenter normal donc sans le static. Mais pour l'utiliser dans 
// d'autres fichiers on devrait faire Revendication r = new Revendication(); puis Joueur j = r.gagnant(borne);
// ou alors on peut faire avec le mot clé static Joueur j = Revendication.gagnant(borne)

public class Revendication {

    public static Joueur gagnant(Borne borne) {
        if (borne.estRevendiquee())
        {
            return borne.getProprietaire();
        }
        if (borne.estComplet())
        {
            Joueur joueur1 = borne.getJoueur1();
            Joueur joueur2 = borne.getJoueur2();

            ArrayList<Carte> main1 = joueur1.getMain();
            ArrayList<Carte> main2 = joueur2.getMain();

            Combinaison combinaison1 = new Combinaison(main1);
            Combinaison combinaison2 = new Combinaison(main2);
            int diff = combinaison1.compareTo(combinaison2);
            if (diff > 0)
            {
                return joueur1;
            }
            else if(diff < 0)
            {
                return joueur2;
            }
            else // la combinaison est la même ET la somme est la même
            {
                return borne.getPremier();
            }


        }
        
        
    }
}

