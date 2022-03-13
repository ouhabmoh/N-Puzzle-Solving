package Model.Recherche;

import Model.Actions.Action;
import Model.Recherche.Heuristique.Heuristique;
import Model.Recherche.OuverDS.Priority;
import Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;

public class A extends Recherche{

    Heuristique heuristique;

    public A(Taquin etatInitial, Taquin but, Heuristique heuristique) {
        super(etatInitial, but);
        this.heuristique = heuristique;
        ouvert = new Priority();
    }

    public List<Action> run(){


        ouvert.add(root);
        while(!ouvert.isEmpty()){

            Noeud noeud = ouvert.remove();
            updateProfondeur(noeud.getProfondeur());

            if(fermer.containsKey(noeud.getTaquin()))
                continue;

            if(isGoal(noeud)){
                System.out.println(noeud.getProfondeur());
                return trackSolution(noeud);
            }


            fermer.put(noeud.getTaquin(),noeud);

            for(Action action:getValidActions(noeud)){
                Noeud newNoeud = createNoeud(noeud, action);
                ouvert.add(newNoeud);
            }
        }

        return Collections.emptyList();
    }


    @Override
    public Noeud createNoeud(Noeud pere, Action action) {

        Noeud noeud =  super.createNoeud(pere, action);
        evaluate(noeud);
        return noeud;

    }

    public void evaluate(Noeud noeud){
        int score = noeud.getProfondeur() + heuristique.evaluate(noeud,but);
        noeud.setScore(score);
    }

    @Override
    public String toString() {
        return "A*";
    }
}
