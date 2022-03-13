package Model.Actions;

import Model.Index;
import Model.Taquin;

public class ActionVide extends Action{

    public ActionVide() {
        v = 0;
    }

    @Override
    public void action(Taquin taquin) {

    }

    @Override
    public boolean isActionValide(Index videIndex, int n) {
        return false;
    }
}
