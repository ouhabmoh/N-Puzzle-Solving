package Model.Actions;

import Model.Index;
import Model.Taquin;

public class Down extends Action{
    public Down() {
        v = -1;
    }

    @Override
    public void action(Taquin taquin) {

        Index videIndex = taquin.getCaseVide();
        Index down = new Index(videIndex.getI()+1,videIndex.getJ());
        taquin.change(videIndex,down);

    }

    @Override
    public boolean isActionValide(Index videIndex, int n) {

        if(videIndex.getI() == n-1)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Down";
    }
}
