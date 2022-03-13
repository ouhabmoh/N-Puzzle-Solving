package Model.Actions;

import Model.Taquin.Index;
import Model.Taquin.Taquin;

public class Right extends Action{
    public Right() {
        v = 2;
    }

    @Override
    public void action(Taquin taquin) {


        Index videIndex = taquin.getCaseVide();
        Index right = new Index(videIndex.getI(),videIndex.getJ()+1);
        taquin.change(videIndex,right);
        taquin.setCaseVideIndex(right);

    }

    @Override
    public boolean isActionValide(Index videIndex, int n) {

        if(videIndex.getJ() == n-1)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Right";
    }
}
