public class house_robber2 {
    public static void main(String[] args) {
        int cost[] = {2,3,2};
        System.out.println(Math.max(get_max(cost, 0, cost.length-2), 
        get_max(cost, 1, cost.length-1)));
    }
    private static int get_max(int []cost,int start,int end){
        if(cost.length == 1) return cost[0];
        int prev_rob=0;
        int max_rob = 0;
        for(int i=start;i<=end;i++){
            int curr_val = Math.max(max_rob,prev_rob+cost[i]);
            prev_rob = max_rob;
            max_rob=curr_val;
        }
        return max_rob;
    }
}
