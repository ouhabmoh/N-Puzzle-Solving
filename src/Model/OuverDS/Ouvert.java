package Model.OuverDS;

import Model.Noeud;

public interface Ouvert {
    boolean isEmpty();
    void add(Noeud noeud);
    Noeud remove();
    int size();
}
