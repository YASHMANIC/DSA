public class wildcard_matching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        boolean dp[][] = new boolean[s.length()][p.length()];
        System.out.println(f(s, p, s.length()-1, p.length()-1,dp));
    }
    private static boolean f(String word,String pattern,int i,int j,boolean[][] dp){
        if(i<0 && j<0) return true;
        if(i>0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int ii=0;ii<=i;ii++){
                if(pattern.charAt(ii) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != false) return dp[i][j];
        if(pattern.charAt(i) == word.charAt(j) || pattern.charAt(i) == '?'){
            return dp[i][j] = f(word, pattern, i-1, j-1, dp);
        }
        if(pattern.charAt(i) == '*'){
            return dp[i][j] =  f(word, pattern, i-1, j, dp) || f(word, pattern, i, j-1, dp);
        }
        return dp[i][j];
    } 
}
