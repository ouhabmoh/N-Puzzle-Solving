package Model.Recherche.Heuristique;

import Model.Recherche.Noeud;
import Model.Taquin.Taquin;

public class Manhatten extends Heuristique {
    @Override
    public int evaluate(Noeud noeud, Taquin etatBut) {

        long t = noeud.getTaquin().getTaquin();
        int n = noeud.getTaquin().getSize() * noeud.getTaquin().getSize();
        int distances = 0;

        for (int i = 0; i < n; i++) {
            long z = t % 10;

            int indexbut = etatBut.searchCaseIndex(z);
            distances += Math.abs(i - indexbut);
            t /= 10;
        }

        return distances;
    }
}
