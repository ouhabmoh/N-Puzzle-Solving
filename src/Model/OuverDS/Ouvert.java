package Model.OuverDS;

import Model.Recherche.Noeud;

public interface Ouvert {
    boolean isEmpty();
    void add(Noeud noeud);
    Noeud remove();
    int size();
}
