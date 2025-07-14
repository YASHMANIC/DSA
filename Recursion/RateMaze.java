package Recursion;

import java.util.*;

public class RateMaze {
    public static void main(String[] args) {
        int [][] arr = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        boolean [][] vis = new boolean[arr.length][arr.length];
        List<String> list = new ArrayList<>();
        int di []= {1,0,0,-1};
        int dj [] = {0,-1,1,0};
       rateMaze(arr, 0, 0, "", list, vis);
        // newRate(arr, 0, 0, "", list, vis, di, dj);
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k));
        }
    }

    public static void rateMaze(int[][]arr,int i,int j,String move,List<String> list,boolean[][]vis){
        if(i == arr.length-1 && j == arr[0].length-1){
            list.add(move);
            return;
        }

        //downward
        if(i<arr.length-1 && !vis[i+1][j] && arr[i+1][j] == 1){
            vis[i][j] = true;
            rateMaze(arr,i+1,j,move+"D",list,vis);
            vis[i][j] = false;
        }

        //left
        if(j-1>=0 && !vis[i][j-1] && arr[i][j-1] == 1){
            vis[i][j] = true;
            rateMaze(arr,i,j-1,move+"L",list,vis);
            vis[i][j] = false;
        }

        //right

        if(j<arr.length-1  && !vis[i][j+1] && arr[i][j+1] == 1){
            vis[i][j] = true;
            rateMaze(arr,i,j+1,move+"R",list,vis);
            vis[i][j] = false;
        }

        // upward
        if(i-1>=0 && !vis[i-1][j] && arr[i-1][j] == 1){
            vis[i][j] = true;
            rateMaze(arr,i-1,j,move+"U",list,vis);
            vis[i][j] = false;
        }
    }

    public static void newRate(int[][]arr,int i,int j,String move,List<String> list,boolean[][]vis,int[] di,int[] dj){
        if(i == arr.length-1 && j == arr[0].length-1){
            list.add(move);
            return;
        }
        String dir = "DLRU";
        for(int idx=0;idx<arr.length;idx++){
            int nexti = i + di[idx];
            int nextj = j+dj[idx];
            if(nexti>=0 && nextj>=0 && nexti<arr.length && nextj<arr.length && !vis[nexti][nextj] && arr[nexti][nextj] == 1){
                vis[nexti][nextj] = true;
                newRate(arr,nexti,nextj,move+dir.charAt(idx),list,vis,di,dj);
                vis[nexti][nextj] = false;
            }
        }
    }

}
