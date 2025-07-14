import java.util.ArrayList;

public class lcs {
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
        int arr[] = {1,2,1,2,3,4,5,6,7,8,9};
        int n = arr.length;
        printF(0,ans, arr, n);
    }
    public static void printF(int idx, ArrayList<Integer> ans, int arr[], int n){
        if(idx == n){
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
        }
        System.out.println();
        if(ans.size() == 0){
            System.out.println("[]");
        }
        return ;
      }
        ans.add(arr[idx]);
        printF(idx+1,ans,arr,n);
        ans.remove(ans.size()-1);
        printF(idx+1,ans,arr,n);
}
}

