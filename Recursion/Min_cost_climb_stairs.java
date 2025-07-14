package Recursion;

public class Min_cost_climb_stairs {
    public static void main(String[] args) {
        int cost[] = {1,100,1,1,1,100,1,1,100,1};
        int minCost[] = new int[cost.length + 1];
        for(int i=2;i<=cost.length;i++){
            minCost[i] = Math.min((cost[i-1]+minCost[i-1]), (cost[i-2]+minCost[i-2]));
        }
        System.out.println(minCost[cost.length]);
    }
}
