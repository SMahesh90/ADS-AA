// Function to find BFS of Graph from given source s
import java.util.*;

class BFSList {
    static ArrayList<Integer> bfsOfGraph(
        ArrayList<ArrayList<Integer>> adj, int s) {
        int V = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int i : adj.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));       
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));       
        adj.add(new ArrayList<>(Arrays.asList(0)));          
        adj.add(new ArrayList<>(Arrays.asList(2)));          
        
        int src = 0;
        ArrayList<Integer> ans = bfsOfGraph(adj, src);
        System.out.print("BFS : ");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
