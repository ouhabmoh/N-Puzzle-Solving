package Tests;

import Model.Actions.Action;
import Model.Actions.Left;
import Model.Actions.Right;
import Model.Taquin.Pair;
import Model.Taquin.Taquin;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaquinTest {

    @org.junit.jupiter.api.Test
    void getCaseVide() {
        Taquin taquin = new Taquin(123456780,3);
        int caseVide = taquin.getCaseVide();
        assertEquals(0,caseVide);
    }

    @Test
    void testGetCaseVide() {
    }

    @Test
    void searchCase() {
        Taquin taquin = new Taquin(123406785,3);
        int caseIndex = taquin.searchCaseIndex(0);
        assertEquals(4,caseIndex);
    }

    @Test
    void searchCase2() {
        Taquin taquin = new Taquin(123456780,3);
        int caseIndex = taquin.searchCaseIndex(0);
        assertEquals(0,caseIndex);
    }

    @Test
    void searchCase3() {
        Taquin taquin = new Taquin( Long.parseLong("023416785"),3);

        int caseIndex = taquin.searchCaseIndex(0);
        assertEquals(8,caseIndex);
    }

    @Test
    void searchCase4() {
        Taquin taquin = new Taquin(123456780,3);
        int caseIndex = taquin.searchCaseIndex(0);
        assertEquals(0,caseIndex);
    }


    @Test
    void change() {
        Taquin taquin = new Taquin( Long.parseLong("023416785"),3);
        taquin.change(new Pair(4,5));
        System.out.println(taquin.getTaquin());
        assertEquals(423016785,taquin.getTaquin());
    }

    @Test
    void changeDigit() {
        int x = 123456780;
        int index = 2;
        int y = 9;
        int z = Taquin.changeDigit(x, index, y);
        System.out.println(z);
        assertEquals(123456980, z);

    }

    @Test
    void equal(){
        Taquin taquin = new Taquin( Long.parseLong("023416785"),3);
        System.out.println(taquin);
        Taquin taquin1 = new Taquin(203416785,3);
        Action action = new Left();
        action.action(taquin1);
        System.out.println(taquin1);
        assertEquals(taquin, taquin1);
    }

    @Test
    void test0en1(){
        Taquin taquin = new Taquin( 203416785,3);
        System.out.println(taquin);

        Action action = new Left();
        action.action(taquin);
        System.out.println(taquin);
        Action action2 = new Right();
        action2.action(taquin);
        System.out.println(taquin);
        assertNotNull(taquin);
    }

    @Test
    void testArrToInt(){
        List<Integer> t = Arrays.asList(2,0,3,4,1,6,7,8,5);
        Taquin taquin = new Taquin(t, 3);

        assertEquals(203416785, taquin.getTaquin());
    }
}