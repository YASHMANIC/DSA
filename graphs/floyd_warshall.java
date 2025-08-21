public class floyd_warshall {
    public static void main(String[] args) {
        int[][] dist = {{0,5,Integer.MAX_VALUE,10},
                        {Integer.MAX_VALUE,0,3,Integer.MAX_VALUE},
                        {Integer.MAX_VALUE,Integer.MAX_VALUE,0,1},
                        {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0}};
        floydWarshall(dist);
        for(int i=0;i<dist.length;i++){
            if(dist[i][i] < 0){
                System.out.println("Negative cycle");
                break;
            }
        }
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist[i].length;j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] != (int)1e8 && dist[k][j] != (int) 1e8) {
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                    }
                }
            }
        }
    }
}
