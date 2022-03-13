package Model;

import Model.Actions.Action;

public class A extends Recherche{

    Heuristique heuristique;

    public A(Taquin etatInitial, Taquin but, Heuristique heuristique) {
        super(etatInitial, but);
        this.heuristique = heuristique;
        ouvert = new Priority();
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
}
