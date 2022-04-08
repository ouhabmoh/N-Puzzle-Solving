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


    public static Taquin getEtatFinal() {
        Taquin taquin = new Taquin(123804765, Main.getN());

        return taquin;
    }

    public static Taquin getEtatFinalNormale() {
        return new Taquin(12345678, Main.getN());
    }
}
