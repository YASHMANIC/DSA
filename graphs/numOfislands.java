import java.util.*;
import java.util.LinkedList;
public class numOfislands {
    static class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        char [][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '1', '1'},
            {'0', '0', '0', '1', '0'},
            {'0', '1', '1', '0', '0'},
            {'1', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
        System.out.println(NumIslands(grid));
    }
    private static int  numIslands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col] == '1' && !vis[row][col]){
                    count++;
                    bfs(row,col,grid,vis);
                }
            }
        }
        return count;
    }

    private static int NumIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int row = 0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col] == '1' && !vis[row][col]){
                    count++;
                    bfs_helper(row, col, grid, vis);
                }
            }
        }
        return count;
    }

    private static void bfs(int row,int col,char[][] grid,boolean[][] vis){
        // This Method Covers All the Directions including Diagnols
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow = r + delrow;
                    int ncol = c + delcol;
                    if(nrow >=0 && nrow < n && ncol>=0 && ncol<m && grid[nrow][ncol] == '1' && !vis[nrow][ncol]){
                        vis[nrow][ncol] = true;
                        q.offer(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }

    private static void bfs_helper(int row,int col,char[][] grid,boolean[][] vis){
        //This Method Covers only Four directions(Up,Down,Left,Right)
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(row,col));
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {
            {0, 1},   // right
            {1, 0},   // down
            {-1, 0},  // up
            {0, -1}   // left
        };
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for (int i = 0; i < directions.length; i++) {
        int newRow = r + directions[i][0];
        int newCol = c + directions[i][1];
        if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1' && !vis[newRow][newCol]){
            vis[newRow][newCol] = true;
            q.offer(new Pair(newRow,newCol));
        }
        }
        }
    }
}
