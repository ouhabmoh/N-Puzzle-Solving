package Model.Recherche;

import Model.Actions.Action;
import Model.Recherche.OuverDS.QueueO;
import Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;

public class BFS extends Recherche{
    public BFS(Taquin etatInitial, Taquin but) {
        super(etatInitial, but);
        ouvert = new QueueO();
    }

    @Override
    public List<Action> run() {


        ouvert.add(root);
        fermer.put(root.getTaquin(),root);
        while (!ouvert.isEmpty()) {

            Noeud noeud = ouvert.remove();
            updateProfondeur(noeud.getProfondeur());



            for (Action action : getValidActions(noeud)) {
                Noeud newNoeud = createNoeud(noeud, action);
                if (isGoal(newNoeud))
                    return trackSolution(newNoeud);

                if (fermer.containsKey(newNoeud.getTaquin()))
                    continue;

                ouvert.add(newNoeud);
                fermer.put(newNoeud.getTaquin(),newNoeud);
            }
        }

        return Collections.emptyList();
    }

}
