package Recursion;

public class Subsetsym {
    public static void main(String[] args) {
        int [] arr =  {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = arr.length;
        System.out.println(solve(arr, n, sum));
    }
    public static boolean solve(int[]arr,int n,int sum){
        if(sum == 0) return true;
        if(n == 0) return false;
        if(arr[n-1] > sum) return solve(arr, n-1, sum);
        return solve(arr, n-1, sum) | solve(arr, n-1, sum-arr[n-1]);
    }
}
