public class wildcard {
    public static void main(String[] args) {
		String pattern = "*";
        String text = "aa";
		boolean[][] dp = new boolean[pattern.length()][text.length()];
		System.out.println(f(pattern, text, pattern.length()-1, text.length()-1,dp));
	}
	public static boolean f(String pattern, String text , int i,int j,boolean[][] dp){
		if(i<0 && j<0) return true;
		if(i<0 && j>=0) return false;
		if(j<0 && i>=0){
			for(int ii=0;ii<=i;ii++){
				if(pattern.charAt(ii) != '*') return false;
			}
			return true;
		}
		if (dp[i][j] != false) {
			return dp[i][j];
		}
		if(pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
			return dp[i][j] = f(pattern,text,i-1,j-1,dp);
		}
		if(pattern.charAt(i) == '*'){
			return dp[i][j] = f(pattern,text,i-1,j,dp) || f(pattern,text,i,j-1,dp);
		}
		return dp[i][j];
	}
}
