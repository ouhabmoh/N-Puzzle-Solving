package Model.Evaluators;

import Model.Taquin.Taquin;

public class Ev implements Evaluator{
    public Ev() {
    }

    @Override
    public int evaluer(Taquin taquin, Taquin etatBut) {
        return 1;
    }
}
