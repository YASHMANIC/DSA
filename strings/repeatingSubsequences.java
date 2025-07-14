public class repeatingSubsequences {
    public static void main(String[] args) {
        String s1 = "aabebcdd";
        String ans = "";
        int n = s1.length();
        int m = s1.length();
        int [][] dp = new int[n+1][m+1];
        for(int j=0;j<=n;j++) dp[0][j] = 0;
        for(int i=0;i<=m;i++) dp[i][0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s1.charAt(j-1) && i!=j)  {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] =  Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        System.out.println(dp[n][m]);
        while (n > 0 && m > 0) {
            // If there's a match and indices are not the same
            if (s1.charAt(n - 1) == s1.charAt(m - 1) && n != m) {
                ans = ans + s1.charAt(n - 1);
                n--;
                m--;
            } else if (dp[n - 1][m] > dp[n][m - 1]) {
                n--;
            } else {
                m--;
            }
        }
        String reversed = new StringBuilder(ans)
                .reverse()
                .toString();
        System.out.println(reversed);
}
}
