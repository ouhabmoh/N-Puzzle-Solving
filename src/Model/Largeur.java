package Model;

import Model.Actions.*;

import java.util.*;

public class Largeur extends Recherche{

    public Largeur(Taquin etatInitial, Taquin but) {
        super(etatInitial, but);
        ouvert = new QueueO();
    }
}
