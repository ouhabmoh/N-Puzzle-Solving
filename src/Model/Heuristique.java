package Model;

public abstract class Heuristique {

    public Heuristique() {
    }

    public abstract int evaluate(Noeud noeud, Taquin etatBut);
}
