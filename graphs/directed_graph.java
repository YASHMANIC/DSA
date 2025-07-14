import java.util.*;

public class directed_graph {
    int V; // number of vertices/nodes
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        directed_graph(int V) {
            this.V = V;
            adjList = new ArrayList<>();

            // Initialize each adjacency list
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addDirectedEdge(int u, int v) {
            adjList.get(u).add(v);  // Add v to u’s list
            // No need to add u to v’s list (because directed)
        }

         // Method to print the directed graph
        void printGraph() {
            for (int i = 0; i < V; i++) {
                System.out.print("Node " + i + ": ");
                for (Integer neighbor : adjList.get(i)) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }
}
