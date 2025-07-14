package Greedy;

public class CoinChange {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
        System.out.println("The total number of ways is " + countWaysToMakeChangeMem(arr, n-1, target));
    }

    public static long countWaysToMakeChange(int[] arr, int n, int target) {
        long dp[][] = new long[n][target+1];
        for(int i=0; i<=target; i++) {
            if(i % arr[0] == 0) dp[0][i] = 1;
        }
        for(int i=1; i<n; i++) {
            for(int t=0; t<=target; t++) {
                long notTaken = dp[i-1][t];
                long taken = 0;
                if(arr[i] <=t) taken = dp[i][t-arr[i]];
                dp[i][t] = notTaken + taken;
            }
        }
        return dp[n-1][target];
    }

    private static long countWaysToMakeChangeMem(int[] arr, int idx, int target) {
        long [][] dp = new long[arr.length][target + 1];
        if(idx == 0){
            if (target % arr[idx] ==0) return 1;
            else return 0;
        }
        if(dp[idx][target] != 0) return dp[idx][target];
        long notTaken = countWaysToMakeChangeMem(arr, idx - 1, target);
        long taken = 0;
        if(arr[idx] <= target) taken = countWaysToMakeChangeMem(arr, idx , target - arr[idx]);
        return dp[idx][target] = notTaken + taken;
    }
}
