package Model.OuverDS;

import Model.Recherche.Noeud;

import java.util.Stack;

public class StackOv implements Ouvert{

    private Stack<Noeud> stack;

    public StackOv() {
        stack = new Stack<>();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void add(Noeud noeud) {
        stack.push(noeud);
    }

    @Override
    public Noeud remove() {
        return stack.pop();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
