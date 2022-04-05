package Tests.ActionsTests;

import Model.Actions.Action;
import Model.Actions.Down;
import Model.Actions.Left;
import Model.Taquin.Pair;
import Model.Taquin.Taquin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftTest {
    @Test
    void action() {
        Taquin taquin = new Taquin(102345678,3);
        Action action = new Left();
        action.action(taquin);
        System.out.println(taquin.getTaquin());
        assertEquals(Long.parseLong("012345678"), taquin.getTaquin());

    }

    @Test
    void getNumberFromPosition() {
        Taquin taquin = new Taquin(102345678,3);
        Action action = new Left();
        Pair pair = action.getNumberFromPosition(taquin);
        assertEquals(new Pair(1,8), pair);
    }

    @Test
    void isActionValide() {
        Taquin taquin = new Taquin(102345678,3);
        Action action = new Left();
        boolean b = action.isActionValide(taquin);
        assertTrue(b);
    }

    @Test
    void isActionValide2() {
        Taquin taquin = new Taquin(142305678,3);
        Action action = new Left();
        boolean b = action.isActionValide(taquin);
        assertTrue(b);
    }

    @Test
    void isActionValide3() {
        Taquin taquin = new Taquin(142350678,3);
        Action action = new Left();
        boolean b = action.isActionValide(taquin);
        assertTrue(b);
    }

    @Test
    void isActionValide4() {
        Taquin taquin = new Taquin(142356078,3);
        Action action = new Left();
        boolean b = action.isActionValide(taquin);
        assertFalse(b);
    }
}