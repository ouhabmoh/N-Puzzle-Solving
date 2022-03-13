package Model.Heuristique;

import Model.Noeud;
import Model.Taquin.Taquin;

public abstract class Heuristique {

    public Heuristique() {
    }

    public abstract int evaluate(Noeud noeud, Taquin etatBut);
}
