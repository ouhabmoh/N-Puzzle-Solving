package Model.Recherche;

import Model.Actions.*;
import Model.Noeud;
import Model.OuverDS.Ouvert;
import Model.Taquin.Taquin;

import java.util.*;

public abstract class Recherche {
    private Noeud root;
    protected Taquin but;
    protected Ouvert ouvert;
    private Map<Taquin, Noeud> fermer = new HashMap<>();
    private static List<Action> actions = Arrays.asList(new Up(), new Down(), new Right(), new Left());
    private int profondeur = 0;
    protected int maxProfondeur = -1;

    public Recherche(Taquin etatInitial, Taquin but) {
        this.root = new Noeud(etatInitial);
        this.but = but;
    }



    public List<Action> run(){


        ouvert.add(root);
        while(!ouvert.isEmpty()){

            Noeud noeud = ouvert.remove();
            updateProfondeur(noeud.getProfondeur());

            if(isGoal(noeud)){
                System.out.println(noeud.getProfondeur());
                return getSolution(noeud);
            }

            if(profondeur == maxProfondeur){
                fermer.put(noeud.getTaquin(),noeud);
                continue;
            }


            if(fermer.containsKey(noeud.getTaquin()))
                continue;


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
        return taquin.equals(but);
    }

    public List<Action> getSolution(Noeud goal){
        List<Action> actions = new ArrayList<>(goal.getProfondeur());

        while(goal.getPere() != null){
            actions.add(0, goal.getAction());
            goal= goal.getPere();
        }

        return actions;
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





    public void updateProfondeur(int p){
        if(p == 0)
            profondeur = 0;
        profondeur = p;

        System.out.println("Profondeur: "+profondeur+" Ouvert: "+ouvert.size()+" Fermer: "+fermer.size());

    }

}
