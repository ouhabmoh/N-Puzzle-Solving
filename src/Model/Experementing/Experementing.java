package Model.Experementing;

import Model.Recherche.*;
import Model.Recherche.Heuristique.Heuristique;
import Model.Recherche.Heuristique.MalPlacer;
import Model.Recherche.Heuristique.Manhatten;
import Model.Taquin.Taquin;
import Model.TestingSet;

import java.util.ArrayList;
import java.util.List;

public class Experementing {
    private final List<Taquin> taquins;
    private final Taquin etatBut;

    public Experementing(List<Taquin> taquins, Taquin etatBut) {
        this.taquins = taquins;
        this.etatBut = etatBut;
    }

    public void runExperiments() {

        List<Recherche> rechercheList = prepareRechercheDFSM();
        int i = 0;
        Results results;
        double m;
        while(!rechercheList.isEmpty()){
            Recherche recherche = rechercheList.remove(rechercheList.size()-1);
            m =  ComplexiteTest.getMemoryUsage();

            long time = ComplexiteTest.testTime(recherche);
            double memory = ComplexiteTest.getMemoryUsage();
            // get right statical data about node develope et exploré
            results = new Results(recherche, time, memory-m);
            results.save();
            m = memory;
//            if(i == 40)
//                break;
            i++;
        }

    }

    public List<Recherche> prepareRecherche() {

        List<Double> coef = prepareCoef();

        List<Recherche> recherches = new ArrayList<>();
        for (Taquin taquin : taquins) {
//            Recherche recherche = new Largeur(taquin, etatBut);
//            recherches.add(recherche);
            Heuristique manhatten = new Manhatten();
            int limit = (int) 3 * manhatten.evaluate(new Noeud(taquin),etatBut)/2;
            Recherche recherche2 = new Profondeur(taquin, etatBut,limit);
            recherches.add(recherche2);
//            Recherche recherche4 = new BFSDrias(taquin, etatBut);
//            recherches.add(recherche4);
            Recherche recherche5 = new DFSDrias(taquin, etatBut,limit);
            recherches.add(recherche5);
//            Recherche recherche3 = new A(taquin, etatBut, new Manhatten());
//            recherches.add(recherche3);
//
//            Recherche recherche6 = new ADrias(taquin, etatBut, new Manhatten());
//            recherches.add(recherche6);
//
//            Recherche recherche7 = new A(taquin, etatBut, new MalPlacer());
//            recherches.add(recherche3);
//
//            Recherche recherche8 = new ADrias(taquin, etatBut, new MalPlacer());
//            recherches.add(recherche6);
        }
        return recherches;
    }

    public List<Recherche> prepareRechercheDFSM(){
        List<Double> coef = prepareCoef();

        List<Recherche> recherches = new ArrayList<>();

            for(Double c:coef){
                for (Taquin taquin : taquins) {
                Heuristique manhatten = new Manhatten();
                double limit = c * manhatten.evaluate(new Noeud(taquin),etatBut);
                Recherche recherche1 = new Profondeur(taquin, etatBut,(int) limit);
                recherches.add(recherche1);
                Recherche recherche2 = new DFSDrias(taquin, etatBut,(int) limit);
                recherches.add(recherche2);


            }
        }
        return recherches;
    }

    public List<Recherche> prepareRechercheDFSC(){
        List<Double> coef = prepareCoef();

        List<Recherche> recherches = new ArrayList<>();
        for (Taquin taquin : taquins) {
            for(Double c:coef){


                Heuristique caseMalPlacer = new MalPlacer();
                double limit = c * caseMalPlacer.evaluate(new Noeud(taquin),etatBut);
                Recherche recherche3 = new Profondeur(taquin, etatBut,(int) limit);
                recherches.add(recherche3);
                Recherche recherche4 = new DFSDrias(taquin, etatBut,(int) limit);
                recherches.add(recherche4);

            }
        }
        return recherches;
    }

    public List<Double> prepareCoef(){
        List<Double> coef = new ArrayList<>();
        double j = 1.5;
        for(int i = 0; i < 10; i++){
            coef.add(j);
            j += 0.2;
        }

        return coef;
    }
//
//    public List<TestingSet> prepareTestingSet(){
//        List<TestingSet> testingSets = new ArrayList<>();
//        List<Double> coef = prepareCoef();
//
//
//
//
//            for(Double c:coef){
//                TestingSet testingSet;
//                List<Recherche> recherches = new ArrayList<>();
//
//                for (Taquin taquin : taquins) {
////                    Heuristique caseMalPlacer = new MalPlacer();
////                    double limit = c * caseMalPlacer.evaluate(new Noeud(taquin),etatBut);
//                    Recherche recherche = new ADrias(taquin, etatBut, new Manhatten());
//                    double limit = c * recherche.run().size();
////                    Heuristique manhatten = new Manhatten();
////                    double limit = c * manhatten.evaluate(new Noeud(taquin),etatBut);
//                    Recherche recherche3 = new Profondeur(taquin, etatBut,(int) limit);
//                    recherches.add(recherche3);
////                    Recherche recherche4 = new DFSDrias(taquin, etatBut,(int) limit);
////                    recherches.add(recherche4);
//
//            }
//                testingSet = new TestingSet(c, recherches);
//                testingSets.add(testingSet);
//        }
//        return testingSets;
//    }
//
//    public List<TestingSet> runExperimentsOnTestingSet(){
//        List<TestingSet> testingSets = prepareTestingSet();
//        for(TestingSet testingSet:testingSets){
//
//            List<Recherche> recherches = testingSet.getTaquinList();
//            int size = recherches.size();
//            int size0 = size;
//            boolean isValid = true;
//            int success = 0;
//            while(!recherches.isEmpty()){
//                Recherche recherche = recherches.remove(--size);
//                if(!recherche.run().isEmpty()){
//                    success++;
//                }
//            }
//
//            testingSet.setSuccesRate((double)success/size0);
//
//
//
//        }
//        return testingSets;
//    }

}
