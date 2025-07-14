import java.util.Scanner;

public class climbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        System.out.println(climb(n, dp));
        sc.close();
    }
    private static int climb(int n,int[] dp){
        if(n == 0 || n == 1 || n == 2) return n;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n]; 
    }
}
