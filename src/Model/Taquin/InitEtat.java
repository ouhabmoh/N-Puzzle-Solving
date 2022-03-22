package Model.Taquin;

import Model.Main;

import java.util.Arrays;
import java.util.List;

public class InitEtat {

    public static Taquin getEtatInitial() {
        Taquin taquin = new Taquin(283164705, Main.getN());
//        int[][] mat =  new int[Main.getN()][Main.getN()];
//        mat[0][0] = 2;
//        mat[0][1] = 8;
//        mat[0][2] = 3;
//        mat[1][0] = 1;
//        mat[1][1] = 6;
//        mat[1][2] = 4;
//        mat[2][0] = 7;
//        mat[2][1] = 0;
//        mat[2][2] = 5;
//
//        taquin.setTaquin(mat);
        return taquin;
    }

    public static List<Taquin> getTestingData() {
        List<Taquin> taquins = Arrays.asList(new Taquin(413726058, Main.getN())
                , new Taquin(340126758, Main.getN())
                , new Taquin(152703846, Main.getN())
                , new Taquin(253187046, Main.getN())
                , new Taquin(412608573, Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
//                                            ,new Taquin("283164705", Main.getN())
        );
        return taquins;
    }

    public static Taquin getEtatFinal() {
        Taquin taquin = new Taquin(123804765, Main.getN());

        return taquin;
    }

    public static Taquin getEtatFinalNormale() {
        return new Taquin(123456780, Main.getN());
    }
}
