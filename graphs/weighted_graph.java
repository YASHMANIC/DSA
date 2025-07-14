import java.util.ArrayList;

public class weighted_graph {
    int V; // number of vertices/nodes
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        
        static class Pair {
            int node;
            int weight;
            Pair(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }
        }

        weighted_graph(int V) {
            this.V = V;
            adjList = new ArrayList<>();

            // Initialize each adjacency list
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addWeightedEdge(int u, int v, int weight) {
            adjList.get(u).add(new Pair(v, weight));  // Add v to u’s list with weight
            adjList.get(v).add(new Pair(u, weight));  // Add u to v’s list with weight (because undirected)
        }

         // Method to print the weighted graph
        void printGraph() {
            for (int i = 0; i < V; i++) {
                System.out.print("Node " + i + ": ");
                for (Pair neighbor : adjList.get(i)) {
                    System.out.print("(" + neighbor.node + ", " + neighbor.weight + ") ");
                }
                System.out.println();
            }
        }
}
