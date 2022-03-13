package Model;

import Model.Recherche.A;
import Model.Recherche.Heuristique.Manhatten;
import Model.Recherche.Largeur;
import Model.Recherche.Profondeur;
import Model.Recherche.Recherche;
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
            SaveResults saveResults = new SaveResults(recherche.getRoot().getTaquin(), recherche.getSolution(), time, recherche.getOuvertSize(), recherche.getFermerSize(), recherche.toString());
            saveResults.save();
        }
    }

    public List<Recherche> prepareRecherche(){
        List<Recherche> recherches = new ArrayList<>(taquins.size()*3);
        for(Taquin taquin:taquins){
            Recherche recherche = new Largeur(taquin, InitEtat.getEtatFinal());
            recherches.add(recherche);
            Recherche recherche2 = new Profondeur(taquin, InitEtat.getEtatFinal(),32);
            recherches.add(recherche2);
            Recherche recherche3 = new A(taquin, InitEtat.getEtatFinal(), new Manhatten());
            recherches.add(recherche3);
        }
        return recherches;
    }
}
