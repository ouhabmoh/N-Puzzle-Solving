package Model;

import Model.Recherche.Recherche;
import Model.Taquin.Taquin;

import java.util.List;

public class TestingSet implements Comparable<TestingSet>{
    private double coef;
    private int depthMax;
    private List<Taquin> taquinList;
    private double succesRate;
    private boolean isValid = true;

    public TestingSet(double coef, List<Taquin> taquinList) {
        this.coef = coef;
        this.taquinList = taquinList;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public double getCoef() {
        return coef;
    }



    public List<Taquin> getTaquinList() {
        return taquinList;
    }

    public double getSuccesRate() {
        return succesRate;
    }



    public void setSuccesRate(double succesRate) {
        this.succesRate = succesRate;
    }

    public void setTaquinList(List<Taquin> taquinList) {
        this.taquinList = taquinList;
    }

    @Override
    public String toString() {
        return "TestingSet{" +
                "depthMax=" + coef +
                ", succesRate=" + succesRate +
                '}';
    }



    @Override
    public int compareTo(TestingSet o) {
        if(this.succesRate < o.getSuccesRate())
            return 1;
        else if(this.succesRate > o.getSuccesRate())
            return -1;

        return 0;
    }
}
