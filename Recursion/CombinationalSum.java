package Recursion;
import java.util.*;

public class CombinationalSum {
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8,};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(arr,0,ans,list,target);
        System.out.println(ans);
    }
    private static void solve(int[] arr, int start, List<List<Integer>> ans, List<Integer> list,int target) {
        if(start==arr.length){
            if(target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[start]<=target){
            list.add(arr[start]);
            solve(arr,start,ans,list,target-arr[start]);
            list.remove(list.size()-1);
        }
        solve(arr,start+1,ans,list,target);
    }
}
