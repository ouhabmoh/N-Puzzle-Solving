package Model;

import Model.Taquin.InitEtat;
import Model.Taquin.Taquin;

public class Main {
    public static Taquin etatFinal;
    private static final int n = 3;
    private static Taquin etatInitial;

    public static void main(String[] args) throws CloneNotSupportedException {

        etatInitial = InitEtat.getEtatInitial();
        etatInitial.afficherTaquin();

        etatFinal = InitEtat.getEtatFinal();
        etatFinal.afficherTaquin();
//
//		Recherche recherche = new Largeur(etatInitial, etatFinal);
//
//		long time = ComplexiteTest.testTime(recherche);
//		System.out.println(time);
//		// get right statical data about node develope et exploré
//		Results saveResults = new Results(etatInitial, recherche.getSolution(), time, recherche.getOuvertSize(), recherche.getFermerSize(), recherche.toString());
//		saveResults.save();

        Experementing experementing = new Experementing(InitEtat.getTestingData());
        experementing.runExperiments();

    }


    public static int getN() {
        return n;
    }
}


// 7+6+5+4+3+2+1