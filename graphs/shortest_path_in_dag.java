import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class shortest_path_in_dag {
    static class Pair {
        int v;
        int wt;
        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 6; // Number of edges
        int[][] edges = {
            {0, 1, 2},
            {0, 2, 4},
            {1, 2, 1},
            {1, 3, 7},
            {2, 3, 3},
            {3, 4, 1}
        };
        int[] result = shortestPath(V, E, edges);
        System.out.println(Arrays.toString(result)); // Output: [0, 2,
    }
    public static int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Step 2: Topological Sort
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        // Step 3: Initialize distances
        int[] dis = new int[V];
        Arrays.fill(dis, (int) 1e9);
        dis[0] = 0;  // Assuming source is node 0

        // Step 4: Relax edges in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (dis[node] == (int) 1e9) continue;  // ✅ Skip unreachable nodes

            for (Pair it : adj.get(node)) {
                int v = it.v;
                int wt = it.wt;
                if (dis[node] + wt < dis[v]) {
                    dis[v] = dis[node] + wt;
                }
            }
        }

        // Step 5: Replace unreachable distances with -1
        for (int i = 0; i < V; i++) {
            if (dis[i] == (int) 1e9) dis[i] = -1;
        }

        return dis;
    }

    // Helper DFS for Topo Sort
    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj) {
        visited[node] = true;
        for (Pair neighbor : adj.get(node)) {
            if (!visited[neighbor.v]) {
                dfs(neighbor.v, visited, stack, adj);
            }
        }
        stack.push(node);
    }
}
