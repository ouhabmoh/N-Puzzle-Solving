package Tests;

import Model.Taquin.Pair;
import Model.Taquin.Taquin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaquinTest {

    @org.junit.jupiter.api.Test
    void getCaseVide() {
        Taquin taquin = new Taquin(123456789,3);
        int caseVide = taquin.getCaseVide();
        assertEquals(0,caseVide);
    }

    @Test
    void testGetCaseVide() {
    }

    @Test
    void searchCase() {
        Taquin taquin = new Taquin(123496785,3);
        int caseIndex = taquin.searchCaseIndex(9);
        assertEquals(4,caseIndex);
    }

    @Test
    void searchCase2() {
        Taquin taquin = new Taquin(123456789,3);
        int caseIndex = taquin.searchCaseIndex(9);
        assertEquals(0,caseIndex);
    }

    @Test
    void searchCase3() {
        Taquin taquin = new Taquin( Long.parseLong("923416785"),3);

        int caseIndex = taquin.searchCaseIndex(9);
        assertEquals(8,caseIndex);
    }

    @Test
    void searchCase4() {
        Taquin taquin = new Taquin(123456789,3);
        int caseIndex = taquin.searchCaseIndex(9);
        assertEquals(0,caseIndex);
    }


    @Test
    void change() {
        Taquin taquin = new Taquin( Long.parseLong("923416785"),3);
        taquin.change(new Pair(4,5));
        System.out.println(taquin.getTaquin());
        assertEquals(423916785,taquin.getTaquin());
    }

    @Test
    void changeDigit() {
        int x = 123456789;
        int index = 2;
        int y = 9;
        int z = Taquin.changeDigit(x, index, y);
        System.out.println(z);
        assertEquals(123456989, z);

    }
}