package Model.Evaluators;

import Model.Recherche.Heuristique.Heuristique;
import Model.Recherche.Heuristique.MalPlacer;
import Model.Recherche.Noeud;
import Model.Taquin.Taquin;

public class CaseEv implements Evaluator{
    public CaseEv() {
    }

    @Override
    public int evaluer(Taquin taquin, Taquin etatBut) {
        Heuristique caseMalPlacer = new MalPlacer();
        return caseMalPlacer.evaluate(new Noeud(taquin),etatBut);
    }
}
