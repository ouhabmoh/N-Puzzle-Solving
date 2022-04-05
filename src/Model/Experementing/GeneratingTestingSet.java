package Model.Experementing;

import Model.Recherche.ADrias;
import Model.Recherche.Heuristique.Heuristique;
import Model.Recherche.Heuristique.MalPlacer;
import Model.Recherche.Heuristique.Manhatten;
import Model.Recherche.Noeud;
import Model.Recherche.Profondeur;
import Model.Recherche.Recherche;
import Model.Taquin.InitEtat;
import Model.Taquin.Solvable;
import Model.Taquin.Taquin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GeneratingTestingSet {
    private int numberOfSets;
    private Map<Taquin, Taquin> taquinList;
    public GeneratingTestingSet(int numberOfSets) {
        this.numberOfSets = numberOfSets;
        this.taquinList = new HashMap<>(numberOfSets);
    }


    public void generate(){
        int i = 0;
        while(i < numberOfSets){
            Taquin taquin = generateRandomSolvableTaquin();
            if(taquinList.containsKey(taquin))
                continue;
            taquinList.put(taquin,taquin);
            i++;
        }

    }

    public void save(){
        try (FileWriter out = new FileWriter("testSets.txt", true)) {


            for (Map.Entry<Taquin,Taquin> entry : taquinList.entrySet())
                out.write(entry.getKey().toString());



        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Taquin generateRandomSolvableTaquin(){

        Taquin taquin;
        while(true){

            taquin = generateRandomTaquin();
            Solvable solvable = new Solvable(3);
            if(solvable.isSolvable(taquin))
                break;
        }

        return taquin;
    }

    public static Taquin generateRandomTaquin(){
        List<Integer> t = Arrays.asList(0,1,2,3,4,5,6,7,8);
        Collections.shuffle(t);
        Taquin taquin = new Taquin(t,3);
        return taquin;
    }

    public void saveManhatten(){
        try (FileWriter outM = new FileWriter("DataManhatten.csv", true);
             FileWriter outC = new FileWriter("DataCases.csv", true);
             FileWriter outA = new FileWriter("DataA.csv", true);
             FileWriter outAll = new FileWriter("DataAll.csv", true)) {

            Taquin taquin;
            for (Map.Entry<Taquin,Taquin> entry : taquinList.entrySet()){
                taquin = entry.getKey();
                Heuristique manhatten = new Manhatten();
                int score = manhatten.evaluate(new Noeud(taquin),InitEtat.getEtatFinalNormale());

                Recherche recherche = new ADrias(taquin,InitEtat.getEtatFinalNormale(),manhatten);
                int scoreA = recherche.run().size();

                int rightDepth = getRightDepth(entry.getKey(), scoreA);
                outM.write(score+","+rightDepth+"\n");
                Heuristique cases = new MalPlacer();
                int scoreC = cases.evaluate(new Noeud(taquin),InitEtat.getEtatFinalNormale());
                outC.write(scoreC+","+rightDepth+"\n");


                outA.write(scoreA+","+rightDepth+"\n");
                outAll.write(scoreA+","+scoreC+","+score+","+rightDepth+"\n");
            }




        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRightDepth(Taquin etatInitial, int startingDepth){

        int depth = startingDepth;
        int solution;
        while (true) {
            while(true){
                Recherche recherche = new Profondeur(etatInitial, InitEtat.getEtatFinalNormale(), depth);
                solution = recherche.run().size();
                if(solution != 0)
                    break;
                depth++;

            }
            int j = 0;
            while(j < 5){
                Recherche recherche = new Profondeur(etatInitial, InitEtat.getEtatFinalNormale(), depth);
                solution = recherche.run().size();
                if(solution == 0)
                    break;
                j++;
            }
            if(j >= 5)
                break;

            depth++;
        }
        return depth;

    }


    public Collection<Taquin> getTaquinList() {
        return  taquinList.values();
    }
}
