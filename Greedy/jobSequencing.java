package Greedy;

import java.io.IOException;
import java.util.Arrays;

public class jobSequencing {
    static class Job{
        int jpb,deadline,profit;
        public Job(int job,int deadline,int profit){
            this.jpb=job;
            this.deadline=deadline;
            this.profit=profit;
        }
    }
     static class Solve{
         int[] res(Job[] arr,int n){
             Arrays.sort(arr,(a,b)->b.profit-a.profit);
             int maxi = 0;
             for(int i=0;i<n;i++){
                 if(arr[i].deadline > maxi){
                     maxi=arr[i].deadline;
                 }
             }
             boolean slots[] = new boolean[maxi+1];
             int jobs=0,profit=0;
             for(int i=0;i<n;i++){
                 for(int j = arr[i].deadline;j>0;j--){
                     if(slots[j] == false){
                         profit+=arr[i].profit;
                         slots[j]=true;
                         jobs++;
                         break;
                     }
                 }
             }
             int ans[] = new int[2];
             ans[0] = jobs;
             ans[1] = profit;
             return ans;
         }
     }
        public static void main(String[] args) throws IOException {
            Job[] arr = new Job[4];
            arr[0] = new Job(1,4,20);
            arr[1] = new Job(2, 1, 1);
            arr[2] = new Job(3, 1, 40);
            arr[3] = new Job(4, 1, 30);
            Solve ob = new Solve();
            int res[] = ob.res(arr,arr.length);
            System.out.println(res[0] + ":" + res[1]);
        }
}
