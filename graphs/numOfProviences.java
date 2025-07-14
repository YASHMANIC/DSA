import java.util.*;
public class numOfProviences {
    public static void main(String[] args){
        undirected_Graph graph = new undirected_Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        ArrayList<ArrayList<Integer>> adj = graph.get_List();
        System.out.println(numProvinces(adj,adj.size()));
    }
    private static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
//        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
//        for(int i=0;i<V;i++){
//            adjList.add(new ArrayList<Integer>());
//        }
//        for(int i=0;i<V;i++){
//            for(int j=0;j<V;j++){
//                if(adj.get(i).get(j) == 1 && i != j){
//                    adjList.get(i).add(j);
//                    adjList.get(j).add(i);
//                }
//            }
//        }
        boolean vis[] = new boolean[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(adj,i,vis);
            }
        }
        return count;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj,int node,
                    boolean vis[]){
        if(vis[node]) return;
        vis[node] = true;
        for(Integer i:adj.get(node)){
            if(!vis[i]){
                dfs(adj,i,vis);
            }
        }
    }
}
