public class editdistance{
    public static void main(String[] args){
        String s1 = "horse";
        String s2 = "ros";
        int[][]dp = new int[s1.length()][s2.length()];
        System.out.println(editDistance(s1, s2, s1.length()-1, s2.length()-1,dp));
    }
    public static int editDistance(String s1, String s2, int i, int j,int[][] dp){
        if(j<0) return i+1;
        if(i<0) return j+1;
        if(dp[i][j] != 0) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = editDistance(s1, s2, i-1, j-1,dp);
        return dp[i][j] = 1 + Math.min(editDistance(s1, s2, i, j-1,dp), Math.min(editDistance(s1, s2, i-1, j,dp), editDistance(s1, s2, i-1, j-1,dp)));
    }
}