package Model.Actions;

import Model.Taquin.Index;
import Model.Taquin.Pair;
import Model.Taquin.Taquin;

import java.util.Objects;

public abstract class Action {
    protected int v;

    public void action(Taquin taquin){
        taquin.change(getNumberFromPosition(taquin));
    }


    public abstract boolean isActionValide(Taquin taquin);


    public int getV() {
        return v;
    }

    public boolean eq(Action action) {
        return v == -action.getV();
    }

    public abstract Pair getNumberFromPosition(Taquin taquin);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return getV() == action.getV();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getV());
    }
}
