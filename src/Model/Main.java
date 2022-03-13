package Model;

import Model.Recherche.Heuristique.Manhatten;
import Model.Recherche.A;
import Model.Recherche.Recherche;
import Model.Taquin.InitEtat;
import Model.Taquin.Taquin;

public class Main {
    private static int n = 3;
	private static Taquin etatInitial;
	public static Taquin etatFinal;
    public static void main(String[] args) throws CloneNotSupportedException {

	    etatInitial =  InitEtat.getEtatInitial();
	    etatInitial.afficherTaquin();

		etatFinal = InitEtat.getEtatFinal();
		etatFinal.afficherTaquin();

		Recherche recherche = new A(etatInitial, etatFinal, new Manhatten());

		long time = TimeTest.testTime(recherche);
		System.out.println(time);
		// get right statical data about node develope et exploré
		SaveResults saveResults = new SaveResults(etatInitial, recherche.getSolution(), time, recherche.getOuvertSize(), recherche.getFermerSize(), "A*");
		saveResults.save();

    }


    public static int getN() {
        return n;
    }
}


 // 7+6+5+4+3+2+1