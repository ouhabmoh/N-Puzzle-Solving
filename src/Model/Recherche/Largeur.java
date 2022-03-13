package Model.Recherche;

import Model.Recherche.OuverDS.QueueO;
import Model.Taquin.Taquin;

public class Largeur extends Recherche{

    public Largeur(Taquin etatInitial, Taquin but) {
        super(etatInitial, but);
        ouvert = new QueueO();
    }
}
