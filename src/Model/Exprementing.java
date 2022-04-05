package Model;

import Model.Evaluators.Evaluator;
import Model.Recherche.Profondeur;
import Model.Recherche.Recherche;
import Model.Taquin.InitEtat;
import Model.Taquin.Taquin;

import java.util.List;

public class Exprementing {
    private PrepareTestingSets prepareTestingSets;
    private Evaluator evaluator;

    public Exprementing(PrepareTestingSets prepareTestingSets, Evaluator evaluator) {
        this.prepareTestingSets = prepareTestingSets;
        this.evaluator = evaluator;
    }

    public void run(){
        for(TestingSet testingSet: prepareTestingSets.getTestingSets()){

            List<Taquin> taquinList = testingSet.getTaquinList();

            int success = 0;
            Recherche recherche;
            Taquin etatBut = InitEtat.getEtatFinalNormale();

            for(Taquin taquin:taquinList){
                int seuil = calculateSeuil(taquin, etatBut, testingSet.getCoef());
                recherche = new Profondeur(taquin, etatBut, seuil);
                if(!recherche.run().isEmpty()){
                    success++;
                }
            }
            double successRate = (double)success/taquinList.size();
            System.out.println(successRate);

            testingSet.setSuccesRate(successRate);
        }
    }

    private int calculateSeuil(Taquin taquin, Taquin etatBut, double coef){
        return (int) (coef * evaluator.evaluer(taquin, etatBut));
    }
}
