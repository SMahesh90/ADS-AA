import java.util.*;
public class TSP {
    private int[][] graph;
    private int n, minCost = Integer.MAX_VALUE;
    private int[] bestPath;
    public TSP(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        this.bestPath = new int[n + 1];
    }
    private void tsp(int level, int cost, int[] path, boolean[] visited) {
        if (level == n) {
            int finalCost = cost + graph[path[level - 1]][path[0]];
            if (finalCost < minCost) {
                minCost = finalCost;
                System.arraycopy(path, 0, bestPath, 0, n);
                bestPath[n] = bestPath[0];
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[level] = i;
                tsp(level + 1, cost + graph[path[level - 1]][i], path, visited);
                visited[i] = false;
            }
        }
    }
    public void solveTSP() {
        boolean[] visited = new boolean[n];
        int[] path = new int[n + 1];
        visited[0] = true;
        path[0] = 0;
        tsp(1, 0, path, visited);
        System.out.println("Cost: " + minCost + "\nPath: " + Arrays.toString(bestPath));
    }
    public static void main(String[] args) {
        int[][] graph = {{0, 10, 15, 20}, {10, 0, 35, 25}, {15, 35, 0, 30}, {20, 25, 30, 0}};
        new TSP(graph).solveTSP();
    }
}
