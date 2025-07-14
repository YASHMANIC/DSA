public class longestincreasingsubsequence {
    public static void main(String[] args) {
        int [] arr = {10,9,2,5,3,7,101,18};
        int [][] dp = new int[arr.length][arr.length+1];
        System.out.println(f(arr,0,-1,arr.length,dp));
    }
    public static int f(int[] arr,int idx,int prev,int n,int [][]dp){
        if(idx == n) return 0;
        if(dp[idx][prev+1] != 0) return dp[idx][prev+1];
        int len = 0 + f(arr,idx+1,prev,n,dp);
        if(prev == -1 || arr[idx]>arr[prev]) len = Math.max(len,1+f(arr,idx+1,idx,n,dp));
        return dp[idx][prev+1]=len;
    }
}
