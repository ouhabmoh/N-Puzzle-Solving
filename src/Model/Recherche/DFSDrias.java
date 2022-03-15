package Model.Recherche;

import Model.Actions.Action;
import Model.Recherche.OuverDS.StackOv;
import Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;

public class DFSDrias extends Recherche {
    private final int maxProfondeur;

    public DFSDrias(Taquin etatInitial, Taquin but, int maxProfondeur) {
        super(etatInitial, but);
        this.maxProfondeur = maxProfondeur;
        ouvert = new StackOv();
    }

    public List<Action> run() {


        ouvert.add(root);
        while (!ouvert.isEmpty()) {

            Noeud noeud = ouvert.remove();
            updateProfondeur(noeud.getProfondeur());

            fermer.put(noeud.getTaquin(), noeud);


            if (profondeur == maxProfondeur)
                continue;


            for (Action action : getValidActions(noeud)) {
                Noeud newNoeud = createNoeud(noeud, action);

                if (fermer.containsKey(newNoeud.getTaquin()))
                    continue;

                if (ouvert.contain(newNoeud))
                    continue;

                if (isGoal(newNoeud))
                    return trackSolution(newNoeud);

                ouvert.add(newNoeud);
            }
        }

        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "DFSDrias";
    }
}
