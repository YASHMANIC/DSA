public class edit_distance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int hdp[][] = new int[word1.length()+1][word2.length()+1];
        System.out.println(helper(word1.length()-1, word2.length()-1, word1, word2, hdp));
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            dp[i][0]= i;
        }
        for(int j=0;j<=word2.length();j++){
            dp[0][j] = j;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
            }
        }
        System.out.println(dp[word1.length()][word2.length()]);
    }
    private static int helper(int i,int j,String word1,String word2,int dp[][]){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != 0) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = helper(i-1, j-1, word1, word2, dp);
        return dp[i][j] = 1+Math.min(helper(i-1, j, word1, word2, dp),Math.min(
            helper(i-1, j-1, word1, word2, dp),
            helper(i, j-1, word1, word2, dp)));
    }
}
