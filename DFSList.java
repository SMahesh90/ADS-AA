import java.util.*;

public class DFSList {
    static void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node) {
        visited.add(node);
        System.out.print(node + " ");
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 2, 3));
        graph.put(2, Arrays.asList(0, 1, 3));
        graph.put(3, Arrays.asList(1, 2));
        
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfs(graph, visited, 0);
    }
}
