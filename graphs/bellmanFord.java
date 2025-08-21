import java.util.*;
public class bellmanFord {
    public static void main(String[] args) {
        int V = 5;
        int edges[][] = {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
        int src = 0;
        int [] res = bellmanFord(V,edges,src);
        for(int i : res){
            System.out.println(i);
        }
    }
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src] = 0;
        for(int i=0;i<V-1;i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u]!= (int)1e8 && dist[u]+wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(int[] edge : edges){
            int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u] != (int)1e8 && dist[u]+wt < dist[v]){
                    return new int[]{-1} ;
                }
        }
        return dist;
    }
}
