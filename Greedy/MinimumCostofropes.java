package Greedy;
import java.util.PriorityQueue;

public class MinimumCostofropes {
    public static void main(String[] args) {
        int []arr =  {4, 2, 7, 6, 9};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int ans = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            ans += first + second;
            pq.add(first + second);
        }
        System.out.println(ans);
    }
}
