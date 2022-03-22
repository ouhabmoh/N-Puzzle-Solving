package Model.Actions;

import Model.Taquin.Index;
import Model.Taquin.Pair;
import Model.Taquin.Taquin;

public class ActionVide extends Action {

    public ActionVide() {
        v = 0;
    }



    @Override
    public Pair getNumberFromPosition(Taquin taquin) {
        return null;
    }

    @Override
    public boolean isActionValide(Taquin taquin) {
        return false;
    }
}
