import java.util.*;

public class Main{
    public static void bfs(int [][] graph,int start){
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[graph.length];
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for (int i=0;i<graph[node].length ; i++){
                if (graph[node][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args){
        int [][] graph = {
            {0,1,1,0},{1,1,0,1},{0,0,1,1},{1,1,1,0}
        };
        System.out.println("BFS : ");
        bfs(graph,0);
    }
}
