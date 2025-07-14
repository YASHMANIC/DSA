import java.util.ArrayList;
import java.util.*;

public class threesum {
    public static void main(String[] args) {
        int arr[] = {0,1,1};
        Arrays.sort(arr);
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = arr.length-1;
            while(j < k){
             int sum = arr[i] + arr[j] + arr[k];
             if(sum > 0) k--;
             else if(sum < 0) j++;
             else {
                 ans.add(Arrays.asList(arr[i],arr[j],arr[k]));
                 j++;
                 k--;
                 while(j < k && arr[j] == arr[j-1]) j++;
                 while(j < k && arr[k] == arr[k+1]) k--;
             }
            }
        }
        System.out.println(ans);
    }
}
