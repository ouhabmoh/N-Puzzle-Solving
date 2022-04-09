package Model;

import Model.Taquin.InitEtat;
import Model.Taquin.Taquin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        List<Taquin> taquinList = InitEtat.readTestingData("testSetsALL.txt");
        Map<Taquin, Taquin> taquinM = new HashMap<>(10000);
        int s = taquinList.size();
        int i = 0;
        while(i < 10000){
            Random random = new Random();
            int r = random.nextInt(s);
            Taquin taquin = taquinList.get(r);
            if(taquinM.containsKey(taquin))
                continue;
            taquinM.put(taquin,taquin);
            i++;
        }

        try (FileWriter out = new FileWriter("testSetMini2.txt", true)) {


            for (Map.Entry<Taquin,Taquin> entry : taquinM.entrySet())
                out.write(entry.getKey().toString());



        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
