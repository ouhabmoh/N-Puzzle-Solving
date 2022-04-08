package Model.Evaluators;

import Model.Recherche.A;

import Model.Recherche.Heuristique.Manhatten;
import Model.Recherche.Recherche;
import Model.Taquin.Taquin;

public class A_Star_EV implements Evaluator{
    public A_Star_EV() {
    }

    @Override
    public int evaluer(Taquin taquin, Taquin etatBut) {
        Recherche recherche = new A(taquin, etatBut, new Manhatten());
        return recherche.run().size();
    }
}
