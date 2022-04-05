package Model.Evaluators;

import Model.Taquin.Solvable;
import Model.Taquin.Taquin;

public class InvEv implements Evaluator{
    public InvEv() {
    }

    @Override
    public int evaluer(Taquin taquin, Taquin etatBut) {
        Solvable solvable = new Solvable(3);
        return solvable.getInvCount(taquin.taquinArr())-solvable.getInvCount(etatBut.taquinArr());
    }
}
