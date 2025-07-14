package Recursion;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> per = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean [] vis = new boolean[arr.length];
        solve(arr, 0, ans, list,vis);
        permutations(arr, 0, per);
        System.out.println(ans);
        System.out.println(per);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;    
    }

    public static void permutations(int[] arr, int n, List<List<Integer>> ans){
        if(n == arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int i=n;i<arr.length;i++){
            swap(arr, i, n);
            permutations(arr, n+1, ans);
            swap(arr, i, n);
        }
    }

    public static void solve(int[] arr, int n, List<List<Integer>> ans, List<Integer> list,boolean[]vis){
        if(n == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                vis[i] = true;
                list.add(arr[i]);
                solve(arr, n+1, ans, list, vis);
                vis[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
