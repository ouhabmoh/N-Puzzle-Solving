package Model.Recherche;

import Model.Actions.*;
import Model.Recherche.OuverDS.Ouvert;
import Model.Experementing.Runnable;
import Model.Taquin.Taquin;

import java.util.*;

public abstract class Recherche implements Runnable {
    protected static List<Action> actions = Arrays.asList(new Up(), new Down(), new Right(), new Left());
    protected Noeud root;
    protected Taquin but;
    protected Ouvert ouvert;
    protected Map<Taquin, Noeud> fermer = new HashMap<>();
    protected int profondeur = 0;
    protected List<Action> solution = Collections.emptyList();
    protected int nDeveloper = 0;
    protected int nGenerer = 0;

    public Recherche(Taquin etatInitial, Taquin but) {
        this.root = new Noeud(etatInitial);
        this.but = but;
    }


    public abstract List<Action> run();

    public boolean isGoal(Noeud noeud) {
        Taquin taquin = noeud.getTaquin();
        return taquin.getTaquin() == but.getTaquin();
    }

    public List<Action> trackSolution(Noeud goal) {
        List<Action> actions = new ArrayList<>(goal.getProfondeur());

        while (goal.getPere() != null) {
            actions.add(0, goal.getAction());
            goal = goal.getPere();
        }
        solution = actions;
        return actions;
    }

    public List<Action> getSolution() {
        return solution;
    }

    public List<Action> getValidActions(Noeud noeud) {

        List<Action> validActions = new ArrayList<>();
        for (Action action : actions) {
            if (noeud.validAction(action) && !action.eq(noeud.getAction()))
                validActions.add(action);
        }
        Collections.shuffle(validActions);

        return validActions;
    }

    public Noeud createNoeud(Noeud pere, Action action) {
        Taquin taquin = null;
        try {
            taquin = (Taquin) pere.getTaquin().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        action.action(taquin);

        Noeud noeud = new Noeud(taquin, action, pere);

        return noeud;
    }


    public void reset() {
        ouvert.clear();
        fermer.clear();
        profondeur = 0;
    }


    public void updateProfondeur(int p) {

        profondeur = p;

        // System.out.println("Profondeur: "+profondeur+" Ouvert: "+ouvert.size()+" Fermer: "+fermer.size());

    }

    public int getOuvertSize() {
        return ouvert.size();
    }

    public int getFermerSize() {
        return fermer.size();
    }

    public int getnDeveloper() {
        return nDeveloper;
    }

    public int getnGenerer() {
        return nGenerer;
    }

    public Noeud getRoot() {
        return root;
    }


}
