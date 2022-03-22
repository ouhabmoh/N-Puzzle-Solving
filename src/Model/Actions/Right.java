package Model.Actions;

import Model.Taquin.Index;
import Model.Taquin.Pair;
import Model.Taquin.Taquin;

public class Right extends Action {
    public Right() {
        v = 2;
    }



    public Pair getNumberFromPosition(Taquin taquin){
        //102345678
        int i = taquin.getCaseVide()-1;
        int k = (int) Math.pow(10,i);
        long t = taquin.getTaquin();
        int x = (int) (t/k)%10;
        return new Pair(x,i);
    }

    @Override
    public boolean isActionValide(Taquin taquin) {
        int videIndex = taquin.getCaseVide();
        int n = taquin.getSize();
        return videIndex % n != 0;
    }

    @Override
    public String toString() {
        return "Right";
    }
}
