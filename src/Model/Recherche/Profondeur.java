package Model.Recherche;

import Model.OuverDS.StackOv;
import Model.Taquin.Taquin;

public class Profondeur extends Recherche{


    public Profondeur(Taquin etatInitial, Taquin but) {
        super(etatInitial, but);
        ouvert = new StackOv();
    }

    public Profondeur(Taquin etatInitial, Taquin but, int maxProfondeur) {
        super(etatInitial, but);
        this.maxProfondeur = maxProfondeur;
        ouvert = new StackOv();
    }
}
