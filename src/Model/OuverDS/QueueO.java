package Model.OuverDS;

import Model.Noeud;

import java.util.LinkedList;
import java.util.Queue;

public class QueueO implements Ouvert{

    private Queue<Noeud> queue;

    public QueueO() {
        queue = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void add(Noeud noeud) {
         queue.add(noeud);
    }

    @Override
    public Noeud remove() {
        return queue.remove();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
