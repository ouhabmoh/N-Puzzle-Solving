package Model.Recherche;

import Model.Actions.Action;
import Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;

public class DFS2 extends DFSDrias{

    public DFS2(Taquin etatInitial, Taquin but, int maxProfondeur) {
        super(etatInitial, but, maxProfondeur);
    }

    @Override
    public List<Action> run() {

        ouvert.add(root);
        while (!ouvert.isEmpty()) {

            Noeud noeud = ouvert.remove();
            updateProfondeur(noeud.getProfondeur());



            if (profondeur == maxProfondeur)
                continue;


            for (Action action : getValidActions(noeud)) {
                Noeud newNoeud = createNoeud(noeud, action);



                if (isGoal(newNoeud))
                    return trackSolution(newNoeud);

                ouvert.add(newNoeud);
            }
        }

        return Collections.emptyList();
    }
}
