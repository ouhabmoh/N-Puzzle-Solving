package Model.Actions;

import Model.Taquin.Index;
import Model.Taquin.Pair;
import Model.Taquin.Taquin;

public class Left extends Action {
    public Left() {
        v = -2;
    }



    public Pair getNumberFromPosition(Taquin taquin){
        //123405678
        int i = taquin.getCaseVide()+1;
        int k = (int) Math.pow(10,i);
        long t = taquin.getTaquin();
        int x = (int) (t/k)%10;
        return new Pair(x,i);
    }

    @Override
    public boolean isActionValide(Taquin taquin) {
        int videIndex = taquin.getCaseVide();
        int n = taquin.getSize();
        return videIndex%n != (n-1);
    }

    @Override
    public String toString() {
        return "Left";
    }
}
