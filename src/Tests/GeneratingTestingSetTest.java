package Tests;

import Model.Experementing.GeneratingTestingSet;
import Model.Taquin.Solvable;
import Model.Taquin.Taquin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratingTestingSetTest {
    GeneratingTestingSet generatingTestingSet = new GeneratingTestingSet(10);
    @Test
    void generate() {
    }

    @Test
    void generateRandomSolvableTaquin() {
        Taquin taquin = generatingTestingSet.generateRandomSolvableTaquin();
        Solvable solvable = new Solvable(3);
        assertTrue(solvable.isSolvable(taquin));
    }

    @Test
    void generateRandomTaquin() {
        Taquin taquin = generatingTestingSet.generateRandomTaquin();
        Taquin taquin2 = generatingTestingSet.generateRandomTaquin();
        assertNotEquals(taquin, taquin2);
    }
}