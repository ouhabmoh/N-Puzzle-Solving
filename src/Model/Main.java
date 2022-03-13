package Model;

import Model.Actions.Action;
import Model.Heuristique.Heuristique;
import Model.Heuristique.Manhatten;
import Model.Recherche.A;
import Model.Recherche.Recherche;
import Model.Taquin.InitEtat;
import Model.Taquin.Taquin;

import java.util.List;

public class Main {
    private static int n = 3;
	private static Taquin etatInitial;
	public static Taquin etatFinal;
    public static void main(String[] args) throws CloneNotSupportedException {

	    etatInitial =  InitEtat.getEtatInitial();
	    etatInitial.afficherTaquin();

		etatFinal = InitEtat.getEtatFinal();
		etatFinal.afficherTaquin();
		Heuristique heuristique = new Manhatten();
		Recherche recherche = new A(etatInitial, etatFinal, heuristique);
//		Noeud noeudBut = new Noeud(etatFinal);
//		if(largeur.isGoal(noeudBut))
//			exit(1);
		List<Action> actionList = recherche.run();


		actionList.forEach(System.out::println);

    }


    public static int getN() {
        return n;
    }
}


 // 7+6+5+4+3+2+1