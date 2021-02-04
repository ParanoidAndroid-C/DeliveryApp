package sample;

import com.sun.javafx.image.impl.General;

import java.util.Random;

public class GenerateGraph {
    int INF = 1000;
    private int[][] g;

    public int[][] getG() { return g; }

    public GenerateGraph() {
        Random ran = new Random();
        int b = 20;
        g = new int[11][11];

        for (int i = 0; i < 11; i ++) {
            for (int j = 0; j < 11; j++) {
                if ( i == j) g[i][j] = 0;
                else  g[i][j] = INF;
            }
        }

        g[0][3] = g[3][0] = ran.nextInt(b)+10;
        g[0][4] = g[4][0] = ran.nextInt(b)+10;
        g[0][6] = g[6][0] = ran.nextInt(b)+10;
        g[0][7] = g[7][0] = ran.nextInt(b)+10;
        g[0][8] = g[8][0] = ran.nextInt(b)+10;
        g[0][9] = g[9][0] = ran.nextInt(b)+10;
        g[0][10] = g[10][0] = ran.nextInt(b)+10;
        g[1][2] = g[2][1] = ran.nextInt(b)+10;
        g[1][6] = g[6][1] = ran.nextInt(b)+10;
        g[2][7] = g[7][2] = ran.nextInt(b)+10;
        g[3][7] = g[7][3] = ran.nextInt(b)+10;
        g[4][10] = g[10][4] = ran.nextInt(b)+10;
        g[5][6] = g[6][5] = ran.nextInt(b)+10;
        g[5][10] = g[10][5] = ran.nextInt(b)+10;
        g[8][9] = g[9][8] = ran.nextInt(b)+10;
    }

}
