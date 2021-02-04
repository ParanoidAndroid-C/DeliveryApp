package sample;
import java.util.ArrayList;
import java.util.Random;

public class FindTime {
    static int INF = 1000;

    public static int getTime(int[][] g, int destination){
        int[] mintime = new int[11];


        ArrayList<Integer> neighbours = new ArrayList<Integer>();
        boolean[] visited = new boolean[11];
        for (int i = 0; i < 11; i ++) {
            mintime[i] = INF;
            visited[i] = false;
        }

        neighbours.add(0);
        mintime[0] = 0;

        while (neighbours.size() != 0) {
            visited[neighbours.get(0)] = true;
            for (int i = 0; i < 11; i++) {
                if ((g[neighbours.get(0)][i] != INF) && (neighbours.get(0) != i)) {
                    if (mintime[neighbours.get(0)] + g[neighbours.get(0)][i] < mintime[i]) {
                        mintime[i] = mintime[neighbours.get(0)] + g[neighbours.get(0)][i];
                        if (!visited[i]) neighbours.add(i);
                    }
                }
            }
            neighbours.remove(0);
        }

        return mintime[destination];
    }

}
