import java.util.*;
import java.util.LinkedList;
public class graphs {
    static class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static class isCycle_Pair {
        int child;
        int parent;
        public isCycle_Pair(int child,int parent){
            this.child = child;
            this.parent = parent;
        }
    }

    static class nearest_Pair{
            int row;
            int col;
            int dis;
            public nearest_Pair(int row,int col,int dis){
                this.row = row;
                this.col = col;
                this.dis = dis;
            }
    }

    static int[][] directions = {
                {0, 1},   // right
                {1, 0},   // down
                {-1, 0},  // up
                {0, -1}   // left
    };
    
    public static void main(String[] args) {
        // Flood-Fill Algorithm
        int [][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        System.out.println("Original Image");
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length;j++){
                System.out.print(image[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        int sr = 1, sc = 1, newColor = 2;
        int [][] floodFill = floodFill(image, sr, sc, newColor);
        System.out.println("Colored Image");
        for(int i=0;i<floodFill.length;i++){
            for(int j=0;j<floodFill[i].length;j++){
                System.out.print(floodFill[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        // Oranges Rotting Problem
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int time = orangesRotting(grid);
        if(time == -1) {
            System.out.println("All oranges cannot be rotten");
        } else {
            System.out.println("Time taken to rot all oranges: " + time +"Minutes");
        }
        // Cycle Detection in Undirected Graph Using BFS
        int V = 5;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0},
            {1, 3}
        };
        boolean hasCycle = isCycle(V, edges);
        if(hasCycle) {
            System.out.println("Cycle detected in the graph");
        } else {
            System.out.println("No cycle detected in the graph");
        }
        int[][] nearestGrid = {
            {0, 0, 1},
            {0, 0, 0},
            {1, 0, 0}
        };
        int[][] nearestDistances = nearest(nearestGrid);
        System.out.println("Nearest distances from 1s:");
        for(int i=0;i<nearestDistances.length;i++){
            for(int j=0;j<nearestDistances[i].length;j++){
                System.out.print(nearestDistances[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        //eventualSafeNodes
        int graph[][] = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
        };
        List<Integer> safeNodes = eventualSafeNodes(graph);
        System.out.println("Safe Nodes Are");
        for(int i: safeNodes){
            System.out.println(i);
        }
        //Topological Sort
        int[][] topoGraph = {
            {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };
        List<Integer> topoSorted = topoSort(topoGraph.length,topoGraph);
        System.out.println("Topological Sort of the graph:");
        for(int i: topoSorted){
            System.out.print(i + " ");
        }
        // Course Schedule
        int n = 4;
        int[][] prerequisites = {
            {1, 0},
            {2, 1},
            {3, 2}
        };
        boolean canFinishCourses = canFinish(n, prerequisites);
        if(canFinishCourses) {
            System.out.println("\nAll courses can be finished.");
        } else {
            System.out.println("\nNot all courses can be finished due to cyclic dependencies.");    
    }
}
    private static int[][] floodFill(int[][] image,int sr,int sc,int newColor){
        int[][] ans = image;
        int iniColor = image[sr][sc];
        floodFill_helper(image,ans,sr, sc,newColor,directions,iniColor);
        return ans;
    }
    private static void floodFill_helper(int[][] image,int[][] ans,
    int row,int col,int newColor,int[][] directions,int iniColor){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<directions.length;i++){
            int nrow = row + directions[i][0];
            int ncol = col + directions[i][1];
            if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && 
            image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor){
                floodFill_helper(image, ans, nrow, ncol, newColor, directions, iniColor);
            }
        }
    }
    private static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        int cntFresh = 0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col] == 2){
                    q.offer(new Pair(row,col,0));
                    vis[row][col] = 2;
                }
                else {
                    vis[row][col] = 0; 
                }
                if(grid[row][col] == 1) cntFresh++;
            }
        }
        int tm = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int time = q.peek().time;
            tm = Math.max(time,tm);
            q.poll();
            for(int i=0;i<directions.length;i++){
                int nrow = r + directions[i][0];
                int ncol = c + directions[i][1];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1){
                    q.offer(new Pair(nrow,ncol,time+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if( cnt != cntFresh) return -1;
        return tm;
    }

    public static boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                if (isCycle_helper(adj, i, vis)) return true;
            }
        }
        return false;
    }

    private static boolean isCycle_helper(ArrayList<ArrayList<Integer>> adj,
    int src,boolean[] vis){
        Queue<isCycle_Pair> q = new LinkedList<>();
        q.offer(new isCycle_Pair(src, -1));
        vis[src] = true;
        while (!q.isEmpty()) {
            int child = q.peek().child;
            int parent = q.peek().parent;
            q.poll();
            for(Integer adjNode : adj.get(child)){
                if(!vis[adjNode]){
                    q.offer(new isCycle_Pair(adjNode, child));
                }
                else if(parent != adjNode) return true;
            }
        }
        return false;
    }
    public static int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dis = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<nearest_Pair> q = new LinkedList<>();
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col] == 1){
                    vis[row][col] = true;
                    q.offer(new nearest_Pair(row,col,0));
                }
            }
        }
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int val = q.peek().dis;
            q.remove();
            dis[row][col] = val;
            for(int i=0;i<directions.length;i++){
                int nrow = row+directions[i][0];
                int ncol = col+directions[i][1];
                if(nrow >= 0 && ncol >=0 && nrow < n && ncol < m && 
                !vis[nrow][ncol]){
                    q.offer(new nearest_Pair(nrow,ncol,val+1));
                    vis[nrow][ncol] = true;
                }
            }
        }
        return dis;
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        int V = graph.length;
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                list.get(i).add(graph[i][j]);
            }
        }
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                eventualSafeNodes_helper(i,list,vis,pathVis,check);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]) result.add(i);
        }
        return result;
    }
    private static boolean eventualSafeNodes_helper(int node,List<List<Integer>> list,boolean[] vis,
    boolean[] pathVis,boolean[] check){
        vis[node]  = true;
        pathVis[node] = true;
        for(int it: list.get(node)){
            if(!vis[it]){
                if(eventualSafeNodes_helper(it,list,vis,pathVis,check)) return true;
            }
            else if(pathVis[it]) return true;
        }
        pathVis[node] = false;
        check[node] = true;
        return false;
    }
    private static void topoSort_helper(int node,boolean[] vis,Stack<Integer> st,
    List<List<Integer>> adj){
        vis[node] = true;
        for(Integer i : adj.get(node)){
            if(!vis[i]){
                topoSort_helper(i,vis,st,adj);
            }
        }
        st.push(node);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert edge list to adjacency list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);  // u -> v
        }
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topoSort_helper(i,vis,st,adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }
    public static boolean canFinish(int n, int[][] prerequisites) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);

            if (adj[current] != null) {
                for (int next : adj[current]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return ans.size() == n;
    }
}
