package Model;

import Model.Actions.Action;
import Model.Experementing.ComplexiteTest;
import Model.Experementing.Experementing;
import Model.Experementing.GeneratingTestingSet;
import Model.Recherche.*;
import Model.Recherche.Heuristique.Heuristique;
import Model.Recherche.Heuristique.MalPlacer;
import Model.Recherche.Heuristique.Manhatten;
import Model.Taquin.InitEtat;
import Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static Taquin etatFinal;
    private static final int n = 3;
    private static Taquin etatInitial;

    public static void main(String[] args) throws CloneNotSupportedException {

        etatInitial = new Taquin(786302514,3);
        etatInitial.afficherTaquin();

        etatFinal = InitEtat.getEtatFinalNormale();
        etatFinal.afficherTaquin();
        Heuristique man = new Manhatten();
        System.out.println(man.evaluate(new Noeud(etatInitial),etatFinal));
        Recherche recherche = new A(etatInitial,etatFinal, man);
        System.out.println(recherche.run().size());
        System.out.println(recherche.getSolution());

        Recherche recherche3 = new BFS(etatInitial,etatFinal);
        System.out.println(recherche3.run().size());
        System.out.println(recherche3.getSolution());

        int seuil = (int) (2 * man.evaluate(new Noeud(etatInitial),etatFinal));
        System.out.println("seuil "+seuil);
        Recherche recherche2 = new DFS(etatInitial,etatFinal,seuil);
        System.out.println(recherche2.run().size());
        List<Action> actions = recherche2.getSolution();
        Noeud noeud = new Noeud(etatInitial);
        for(Action action:actions){
            Noeud newNoeud = recherche2.createNoeud(noeud, action);
            noeud = newNoeud;
            noeud.afficherNoeud();
        }

        System.out.println("ouvert "+recherche2.getOuvertSize());
        System.out.println("fermer "+recherche2.getFermerSize());






    }


    public static int getN() {
        return n;
    }
}


// 7+6+5+4+3+2+1