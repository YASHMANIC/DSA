import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The How Many Sequence:");
        int n = sc.nextInt();
        long dp[] = new long[n+1];
        System.out.println(fib(n, dp));
        sc.close();
    }
    private static long fib(int n,long[] dp){
        if(n == 0) return n;
        if(n == 1) return n;
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
