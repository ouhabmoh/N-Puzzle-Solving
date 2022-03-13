package Model.Recherche;

import Model.Actions.*;
import Model.Recherche.OuverDS.Ouvert;
import Model.Runnable;
import Model.Taquin.Taquin;

import java.util.*;

public abstract class Recherche implements Runnable {
    private Noeud root;
    protected Taquin but;
    protected Ouvert ouvert;
    private Map<Taquin, Noeud> fermer = new HashMap<>();
    private static List<Action> actions = Arrays.asList(new Up(), new Down(), new Right(), new Left());
    private int profondeur = 0;
    protected int maxProfondeur = -1;
    protected List<Action> solution;

    public Recherche(Taquin etatInitial, Taquin but) {
        this.root = new Noeud(etatInitial);
        this.but = but;
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

            if(profondeur == maxProfondeur){
                fermer.put(noeud.getTaquin(),noeud);
                continue;
            }





            fermer.put(noeud.getTaquin(),noeud);

            for(Action action:getValidActions(noeud)){
                Noeud newNoeud = createNoeud(noeud, action);
                ouvert.add(newNoeud);
            }
        }

        return Collections.emptyList();
    }

    public boolean isGoal(Noeud noeud){
        Taquin taquin = noeud.getTaquin();
        return Arrays.deepEquals(taquin.getTaquin(),but.getTaquin());
    }

    public List<Action> trackSolution(Noeud goal){
        List<Action> actions = new ArrayList<>(goal.getProfondeur());

        while(goal.getPere() != null){
            actions.add(0, goal.getAction());
            goal= goal.getPere();
        }
        solution = actions;
        return actions;
    }

    public List<Action> getSolution() {
        return solution;
    }

    public List<Action> getValidActions(Noeud noeud){

        List<Action> validActions = new ArrayList<>();
        for(Action action:actions){
            if(noeud.validAction(action) && !action.eq(noeud.getAction()))
                validActions.add(action);
        }

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


    public void reset(){
        ouvert.clear();
        fermer.clear();
        profondeur = 0;
    }




    public void updateProfondeur(int p){
        if(p == 0)
            profondeur = 0;
        profondeur = p;

        System.out.println("Profondeur: "+profondeur+" Ouvert: "+ouvert.size()+" Fermer: "+fermer.size());

    }

    public int getOuvertSize(){
        return ouvert.size();
    }

    public int getFermerSize(){
        return fermer.size();
    }

}
