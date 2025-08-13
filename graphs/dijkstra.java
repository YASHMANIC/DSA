import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class dijkstra {
    static class Pair{
        int distance;
        int node;
        public Pair(int distance,int node){
            this.distance = distance;
            this.node = node;
        }
    }
    public static int[] dijkstra_by_PQ(int V, int[][] edges, int src) {
        // code here
        long start_time = System.currentTimeMillis();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];
            adj.get(u).add(new Pair(d,v));
            adj.get(v).add(new Pair(d,u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        pq.add(new Pair(0,src));
        int[] dis = new int[V];
        for(int i=0;i<V;i++){
            dis[i] = (int)1e9;
        }
        dis[src] = 0;
        while(!pq.isEmpty()){
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for(Pair p : adj.get(node)){
                int adjNode = p.node;
                int weight = p.distance;
                if(distance + weight < dis[adjNode]){
                    dis[adjNode] = distance + weight;
                    pq.add(new Pair(dis[adjNode],adjNode));
                }
            }
        }
        long end_time = System.currentTimeMillis();
        System.out.println("Time taken by Priority Queue: " + (end_time - start_time));
        return dis;
    }
    public static int[] dijkstra_by_Set(int V, int[][] edges, int src) {
        // code here
        long start_time = System.currentTimeMillis();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];
            adj.get(u).add(new Pair(d,v));
            adj.get(v).add(new Pair(d,u));
        }
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.distance == b.distance) return a.node - b.node;
            return a.distance - b.distance;
        });
        set.add(new Pair(0,src));
        int[] dis = new int[V];
        for(int i=0;i<V;i++){
            dis[i] = (int)1e9;
        }
        dis[src] = 0;
        while(!set.isEmpty()){
            Pair i = set.pollFirst();
            int distance = i.distance;
            int node = i.node;
            for(Pair p : adj.get(node)){
                int adjNode = p.node;
                int weight = p.distance;
                if(distance + weight < dis[adjNode]){
                    set.remove(new Pair(dis[adjNode], adjNode));
                    dis[adjNode] = distance + weight;
                    set.add(new Pair(dis[adjNode],adjNode));
                }
            }
        }
        long end_time = System.currentTimeMillis();
        System.out.println("Time taken by TreeSet: " + (end_time - start_time));
        return dis;
    }
    public static void main(String[] args) {
        int edges[][] = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        int[] pq_result = dijkstra_by_PQ(3, edges, 2);
        int[] set_result = dijkstra_by_Set(3, edges, 2);
        for (int i = 0; i < pq_result.length; i++) {
            System.out.print(pq_result[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < set_result.length; i++) {
            System.out.print(set_result[i] + " ");
        }
    }
}
