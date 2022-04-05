package Model.Taquin;

import Model.Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitEtat {

    public static Taquin getEtatInitial() {
 //       Taquin taquin = new Taquin(283164705, Main.getN());
        Taquin taquin = new Taquin(876543210, Main.getN());

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


    public static List<Taquin> readTestingData(String file){
        List<Taquin> taquins = new ArrayList<>();
        try(FileReader reader = new FileReader(file)){
            BufferedReader br=new BufferedReader(reader);  //creates a buffering character input stream
               //constructs a string buffer with no characters
            String line;
            while((line=br.readLine())!=null)
            {
                Taquin taquin = new Taquin(Long.parseLong(line),3);
                taquins.add(taquin);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return taquins;
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
        return new Taquin(12345678, Main.getN());
    }
}
