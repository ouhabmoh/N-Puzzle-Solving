package Model;

import Model.Experementing.Experementing;
import Model.Experementing.GeneratingTestingSet;
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

//        etatInitial = new Taquin(876543210,3);
//        etatInitial.afficherTaquin();
//
       etatFinal = InitEtat.getEtatFinalNormale();
//        etatFinal.afficherTaquin();
//        Taquin taquin = GeneratingTestingSet.generateRandomSolvableTaquin();
//        taquin.afficherTaquin();
//        Recherche recherche = new A(taquin, etatFinal, new Manhatten());
//        int l = recherche.run().size();
//        System.out.println(l);
//        double limit = 3 * l;
//        Recherche recherche1 = new Profondeur(taquin,etatFinal,(int)limit);

////
//        Heuristique caseMalPlacer = new MalPlacer();
//        Heuristique manhatten = new Manhatten();
//        int limit = (int) 3 * manhatten.evaluate(new Noeud(etatInitial),etatFinal)/2;
//
//        System.out.println(limit);
//		Recherche recherche = new Profondeur(etatInitial, etatFinal,limit);
//
//		long time = ComplexiteTest.testTime(recherche1);
//		System.out.println(time);
//        System.out.println(recherche1.getSolution().size());
//        System.out.println();
//        recherche1 = new Profondeur(taquin,etatFinal,(int)limit);
//        time = ComplexiteTest.testTime(recherche1);
//        System.out.println(time);
//        System.out.println(recherche1.getSolution().size());
//		// get right statical data about node develope et exploré
//		Results saveResults = new Results(etatInitial, recherche.getSolution(), time, recherche.getOuvertSize(), recherche.getFermerSize(), recherche.toString());
//		saveResults.save();
//        GeneratingTestingSet generatingTestingSet = new GeneratingTestingSet(100000);
//        generatingTestingSet.generate();
//        Experementing experementing = new Experementing(generatingTestingSet.getTaquinList().stream().collect(Collectors.toList()), etatFinal);
//        List<TestingSet> testingSets =  experementing.runExperimentsOnTestingSet();
//      // testingSets = testingSets.stream().filter(testingSet -> testingSet.isValid()).collect(Collectors.toList());
//        Collections.sort(testingSets);
//        testingSets.forEach(System.out::println);
//        System.out.println("done");
       // generatingTestingSet.saveManhatten();

//        generatingTestingSet.saveManhatten();
//        Taquin taquin = GeneratingTestingSet.generateRandomSolvableTaquin();
//        Heuristique man = new Manhatten();
//        int score = man.evaluate(new Noeud(taquin),InitEtat.getEtatFinalNormale());
//        Heuristique cases = new MalPlacer();
//        int scoreC = cases.evaluate(new Noeud(taquin),InitEtat.getEtatFinalNormale());
//        Recherche rA = new ADrias(taquin,InitEtat.getEtatFinalNormale(),man);
//        int scoreA = rA.run().size();
//        int depth = generatingTestingSet.getRightDepth(taquin,score);
//        System.out.println(score);
//        System.out.println(depth);
//        int predictedDepth = (int) (25.87937425 + score*0.39781342);
//        int predictedDepth2 = (int)( scoreA*3.55102712 +scoreC*0.93274169 +score*0.50207525);
//        System.out.println(predictedDepth2);
//        Recherche recherche = new Profondeur(taquin,InitEtat.getEtatFinalNormale(),predictedDepth2);
//        System.out.println(recherche.run().size());
//        generatingTestingSet.save();

    //    InitEtat.readTestingData().forEach(System.out::println);

    }


    public static int getN() {
        return n;
    }
}


// 7+6+5+4+3+2+1