package Tests;

import Model.Recherche.Heuristique.Heuristique;
import Model.Recherche.Heuristique.MalPlacer;
import Model.Recherche.Noeud;
import Model.Taquin.Taquin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MalPlacerTest {
    Taquin taquinBut = new Taquin(123456780,3);
    Heuristique malPlacer = new MalPlacer();

    @Test
    void evaluate() {
        Taquin taquin = new Taquin(123780456,3);
        Noeud noeud = new Noeud(taquin);

        assertEquals(5,malPlacer.evaluate(noeud,taquinBut));
    }
}