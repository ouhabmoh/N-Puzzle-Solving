package Model;

import Model.Evaluators.Ev;
import Model.Evaluators.Evaluator;
import Model.Recherche.*;
import Model.Recherche.Heuristique.Heuristique;
import Model.Recherche.Heuristique.Manhatten;
import Model.Taquin.InitEtat;
import Model.Taquin.Solvable;
import Model.Taquin.Taquin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main2 {

    public static Taquin etatFinal;
    private static final int n = 3;
    private static Taquin etatInitial;

    public static void main(String[] args) {
        List<Taquin> taquinList = InitEtat.readTestingData("testSetsALL.txt");
        PrepareTestingSets prepareTestingSets = new PrepareTestingSets(taquinList);
        prepareTestingSets.prepareParametresAndSets(50,200,10);
        Evaluator evaluator = new Ev();
        Exprementing exprementing = new Exprementing(prepareTestingSets,evaluator);
        exprementing.run();

    }
}
