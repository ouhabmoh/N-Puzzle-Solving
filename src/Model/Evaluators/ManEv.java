package Model.Evaluators;

import Model.Recherche.Heuristique.Heuristique;
import Model.Recherche.Heuristique.Manhatten;
import Model.Recherche.Noeud;
import Model.Taquin.Taquin;

public class ManEv implements Evaluator {
    public ManEv() {
    }

    @Override
    public int evaluer(Taquin taquin, Taquin etatBut) {
        Heuristique manhatten = new Manhatten();
        return manhatten.evaluate(new Noeud(taquin),etatBut);
    }
}
