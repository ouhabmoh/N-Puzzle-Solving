package Model;

import Model.Actions.Action;
import Model.Main;
import Model.Recherche.A;
import Model.Taquin.Taquin;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveResults {
    private Taquin taquinInitial;
    private List<Action> solution;
    private long time;
    private int etatDeveloper;
    private int etatExplorer;
    private String algo;

    public SaveResults(Taquin taquinInitial, List<Action> solution, long time, int etatDeveloper, int etatExplorer, String algo) {
        this.taquinInitial = taquinInitial;
        this.solution = solution;
        this.time = time;
        this.etatDeveloper = etatDeveloper;
        this.etatExplorer = etatExplorer;
        this.algo = algo;
    }

    public void save(){

        try (FileWriter out = new FileWriter("result.txt",true)){

            out.write(taquinInitial.getTaquinStr()+"\t");

            out.write(solution.size() +"\t");

            out.write(time +"\t");
            out.write(etatDeveloper +"\t");
            out.write(etatExplorer +"\t");
            out.write(algo+"\t");
            for(Action action:solution)
                out.write(action.toString()+"\t");
            out.write("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
