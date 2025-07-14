
import java.util.ArrayList;
import java.util.Collections;

public class Leaders {
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
        int arr [] =  {16, 17, 4, 3, 5, 2} ;
        int max = Integer.MIN_VALUE;
        for(int i=arr.length - 1 ; i>=0 ; i--){
            if(arr[i] > max){
                ans.add(arr[i]);
            }
            max = Math.max(max , arr[i]);
        }
        Collections.reverse(ans);
        System.out.println(ans);
    }
}