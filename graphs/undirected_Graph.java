import java.util.*;
import java.util.LinkedList;
public class undirected_Graph {
        int V; // number of vertices/nodes
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        undirected_Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>();

        // Initialize each adjacency list
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adjList.get(u).add(v);  // Add v to u’s list
        adjList.get(v).add(u);  // Add u to v’s list (because undirected)
    }

    ArrayList<ArrayList<Integer>> get_List(){
        return adjList;
    }

     // Method to print the graph
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Node " + i + ": ");
            for (Integer neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    ArrayList<Integer> bfs(){
        boolean visited[] = new boolean[V+1];
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.offer(0);
        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            for(Integer i:adjList.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return bfs;
    }

    void dfs_helper(int node,ArrayList<ArrayList<Integer>> adj,
    ArrayList<Integer> dfs,boolean[] visited){
        visited[node] = true;
        dfs.add(node);
        for(Integer i : adj.get(node)){
            if(!visited[i]){
                dfs_helper(i, adj, dfs, visited);
            }
        }
    }

    ArrayList<Integer> dfs(){
        boolean[] visited = new boolean[V+1];
        ArrayList<Integer> dfs = new ArrayList<>();
        visited[0] = true;
        dfs_helper(0, adjList, dfs, visited);
        return dfs;
    }
}
