public class house_robber {
    public static void main(String[] args) {
        int cost[] = {1,2,3,1};
        System.out.println(rob(cost));
    }
    private static int rob(int[] cost){
        if(cost.length == 1) return cost[0];
        int [] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = Math.max(cost[0], cost[1]);
        for(int i=2;i<cost.length;i++){
            dp[i] = Math.max(cost[i]+dp[i-2], dp[i-1]);
        }
        return dp[cost.length-1];
    }
}
