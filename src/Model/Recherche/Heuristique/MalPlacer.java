package Model.Recherche.Heuristique;

import Model.Recherche.Noeud;
import Model.Taquin.Taquin;

public class MalPlacer extends Heuristique{
    @Override
    public int evaluate(Noeud noeud, Taquin etatBut) {

        long t = noeud.getTaquin().getTaquin();
        long t2 = etatBut.getTaquin();
        int n = noeud.getTaquin().getSize() * noeud.getTaquin().getSize();
        int casesMalPlacer = 0;

        for (int i = 0; i < n; i++) {
            long z = t % 10;
            long z2 = t2%10;
            if(z != 0 && z != z2)
                casesMalPlacer++;
            t /= 10;
            t2 /= 10;
        }

        return casesMalPlacer;
    }
}
