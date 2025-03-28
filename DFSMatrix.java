import java.util.*;
public class DFSMatrix {
    static void dfs(int[][] graph, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 1, 0},
                         {1, 0, 1, 1},
                         {1, 1, 0, 1},
                         {0, 1, 1, 0}};
        boolean[] visited = new boolean[graph.length];
        System.out.print("DFS: ");
        dfs(graph, visited, 0);
    }
}
