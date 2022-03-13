package Model.Actions;

import Model.Taquin.Index;
import Model.Taquin.Taquin;

public class Left extends Action {
    public Left() {
        v = -2;
    }

    @Override
    public void action(Taquin taquin) {


        Index videIndex = taquin.getCaseVide();
        Index left = new Index(videIndex.getI(),videIndex.getJ()-1);
        taquin.change(videIndex,left);

    }

    @Override
    public boolean isActionValide(Index videIndex, int n) {

        if(videIndex.getJ() == 0)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Left";
    }
}
