package Tests;

import Model.Taquin.Solvable;
import Model.Taquin.Taquin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolvableTest {

    @Test
    void getInvCount() {
        Taquin taquin = new Taquin(182043765,3);
        Solvable solvable = new Solvable(3);
        System.out.println(taquin.taquinArr()[5]);
        int inv = solvable.getInvCount(taquin.taquinArr());
        assertEquals(10,inv);
    }

    @Test
    void isSolvable() {
        Taquin taquin = new Taquin(182043765,3);
        Solvable solvable = new Solvable(3);
        assertTrue(solvable.isSolvable(taquin));
    }

    @Test
    void isSolvable2() {
        Taquin taquin = new Taquin(812043765,3);
        Solvable solvable = new Solvable(3);
        assertFalse(solvable.isSolvable(taquin));
    }

    @Test
    void isSolvable3() {
        Taquin taquin = new Taquin(Long.parseLong("082143765"),3);
        Solvable solvable = new Solvable(3);
        assertTrue(solvable.isSolvable(taquin));
    }

    @Test
    void isSolvable4() {
        Taquin taquin = new Taquin(182543760,3);
        Solvable solvable = new Solvable(3);
        assertTrue(solvable.isSolvable(taquin));
    }

    @Test
    void isSolvable5() {
        Taquin taquin = new Taquin(182543760,3);
        Taquin taquin2 = new Taquin(Long.parseLong("082143765"),3);
        Solvable solvable = new Solvable(3);
        assertTrue(solvable.isSolvable(taquin, taquin2));
    }

    @Test
    void isSolvable6() {
        Taquin taquin = new Taquin(182543760,3);
        Taquin taquin2 = new Taquin(812043765,3);
        Solvable solvable = new Solvable(3);
        assertFalse(solvable.isSolvable(taquin, taquin2));
    }

    @Test
    void isSolvable7() {
        Taquin taquin = new Taquin(283164705,3);
        Taquin taquin2 = new Taquin(123804765,3);
        Solvable solvable = new Solvable(3);
        assertTrue(solvable.isSolvable(taquin, taquin2));
    }

    @Test
    void isSolvable8() {
        Taquin taquin = new Taquin(812043765,3);
        Taquin taquin2 = new Taquin(812403765,3);
        Solvable solvable = new Solvable(3);
        assertTrue(solvable.isSolvable(taquin, taquin2));
    }

}