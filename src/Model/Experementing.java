package Model;

import Model.Recherche.*;
import Model.Recherche.Heuristique.Manhatten;
import Model.Taquin.InitEtat;
import Model.Taquin.Taquin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Experementing {
    private List<Taquin> taquins;

    public Experementing(List<Taquin> taquins) {
        this.taquins = taquins;
    }

    public void runExperiments(){
        for(Recherche recherche:prepareRecherche()){
            long time = TimeTest.testTime(recherche);
            System.out.println(time);
            // get right statical data about node develope et exploré
            SaveResults saveResults = new SaveResults(recherche, time);
            saveResults.save();
        }
    }

    public List<Recherche> prepareRecherche(){
        List<Recherche> recherches = new ArrayList<>(taquins.size()*3);
        for(Taquin taquin:taquins){
            Recherche recherche = new Largeur(taquin, InitEtat.getEtatFinalNormale());
            recherches.add(recherche);
//            Recherche recherche2 = new Profondeur(taquin, InitEtat.getEtatFinalNormale(),32);
//            recherches.add(recherche2);
            Recherche recherche4 = new BFSDrias(taquin, InitEtat.getEtatFinalNormale());
            recherches.add(recherche4);
//            Recherche recherche5 = new DFSDrias(taquin, InitEtat.getEtatFinalNormale(),32);
//            recherches.add(recherche5);
            Recherche recherche3 = new A(taquin, InitEtat.getEtatFinalNormale(), new Manhatten());
            recherches.add(recherche3);
        }
        return recherches;
    }
}
