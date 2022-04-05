package Model;

import Model.Taquin.Taquin;

import java.util.ArrayList;
import java.util.List;

public class PrepareTestingSets {
    protected List<TestingSet> testingSets = new ArrayList<>();
    protected List<Double> parametres;
    protected List<Taquin> taquinList;

    public PrepareTestingSets(List<Taquin> taquinList) {
        this.taquinList = taquinList;
    }

    public void prepareParametresAndSets(double start, double stop, double step){
        parametres = new ArrayList<>();
        double i = start;
        while(i <= stop){
            parametres.add(i);
            i += step;
        }
        prepareTestingSets();
    }

    private void prepareTestingSets(){
        TestingSet testingSet;
        for(Double p:parametres){
            testingSet = new TestingSet(p, taquinList);
            testingSets.add(testingSet);
        }

    }


    public List<TestingSet> getTestingSets() {
        return testingSets;
    }
}
