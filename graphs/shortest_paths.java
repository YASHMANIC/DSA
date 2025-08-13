import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;;

public class shortest_paths {
    static class ug_Pair{
        int node;
        int dist;
        public ug_Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
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
        int[] result = shortestPathInDAG(V, E, edges);
        System.out.println(Arrays.toString(result)); 
        //Undirected Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int[][] data = {
            {1, 3},
            {0, 2},
            {1, 6},
            {0, 4},
            {3, 5},
            {4, 6},
            {2, 5, 7, 8},
            {6, 8},
            {7, 6}
        };

        for (int[] row : data) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int val : row) {
                list.add(val);
            }
            adj.add(list);
        }
        int[] result2 = shortestPathInUg(adj, 0);
        System.out.println(Arrays.toString(result2));
    }
    private static int[] shortestPathInUg(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int[] res = new int[adj.size()];
        Queue<ug_Pair> q = new LinkedList<>();
        q.offer(new ug_Pair(src,0));
        int inf = (int)1e9; // 1e9 = 1000000000
        Arrays.fill(res,inf);
        res[src] = 0;
        while(!q.isEmpty()){
            int node = q.peek().node;
            q.poll();
            for(Integer neighbour:adj.get(node)){
                if(res[node] + 1 < res[neighbour]){
                    res[neighbour] = 1 + res[node];
                    q.offer(new ug_Pair(neighbour, res[neighbour]));
                }
            }
        }
        for(int i=0;i<res.length;i++){
            if(res[i] == inf) res[i] = -1;
        }
        return res;
    }
    private static int[] shortestPathInDAG(int V, int E, int[][] edges) {
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
