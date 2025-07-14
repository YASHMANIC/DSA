public class longestCommon {
    public static void main(String[] args) {
        String text = "ABCDGH";
        String text2 = "AEDFHR";
        int n = text.length();
        int m = text2.length();
        int [][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for (int j = 1; j <= m; j++) {
                if(text.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        System.out.println("LCS Of String:-" + lcs(dp, n, m, text, text2));
        System.out.println("LCS OF Length " + dp[n][m]);
    }
    static String lcs(int [][]dp,int n,int m,String text,String text2){
        StringBuilder result = new StringBuilder();
        while (n > 0 && m > 0) {
            if(text.charAt(n-1) == text2.charAt(m-1)){
                result.append(text.charAt(n - 1));
                n--;
                m--;
            }
            else if(dp[n - 1][m] > dp[n][m-1]) n--;
            else m--;
        }
        return result.reverse().toString();
    }
}

