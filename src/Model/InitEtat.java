package Model;

public class InitEtat {

    public static Taquin getEtatInitial(){
        Taquin taquin = new Taquin(Main.getN());
        int[][] mat =  new int[Main.getN()][Main.getN()];
        mat[0][0] = 8;
        mat[0][1] = 7;
        mat[0][2] = 6;
        mat[1][0] = 5;
        mat[1][1] = 4;
        mat[1][2] = 3;
        mat[2][0] = 2;
        mat[2][1] = 1;
        mat[2][2] = 0;

        taquin.setTaquin(mat);
        return taquin;
    }

    public static Taquin getEtatFinal(){
        Taquin taquin = new Taquin(Main.getN());
        int[][] mat =  new int[Main.getN()][Main.getN()];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[0][2] = 3;
        mat[1][0] = 4;
        mat[1][1] = 5;
        mat[1][2] = 6;
        mat[2][0] = 7;
        mat[2][1] = 8;
        mat[2][2] = 0;

        taquin.setTaquin(mat);
        return taquin;
    }
}
