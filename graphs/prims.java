import java.util.*;
public class prims {
    class pair{
        int node;
        int distance;
        pair(int node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
    prims obj = new prims();
    int V = 5;
    int[][] edges = {
        {0, 1, 2},
        {0, 3, 6},
        {1, 2, 3},
        {1, 3, 8},
        {1, 4, 5},
        {2, 4, 7},
        {3, 4, 9}
    };
    int mstWeight = obj.spanningTree(V, edges);
    System.out.println("Weight of MST: " + mstWeight);
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(new pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new pair(edge[0],edge[2]));
        }
        boolean[] vis = new boolean[V];
        int sum = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y) -> x.distance-y.distance);
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            if(vis[node]) continue;
            vis[node] = true;
            sum += wt;
            for(pair p : adj.get(node)){
                int adjNode = p.node;
                int adjWt = p.distance;
                if(!vis[adjNode]){
                    pq.add(new pair(adjNode,adjWt));
                }
            }
        }
        return sum;
    }
}
