package searchings;

public class linear {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int val = 5;
        System.out.println("Element Found At="+" "+search(arr,val));
    }
    public static int search(int[]arr,int val) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val) return i;
        }
        return 0;
    }
}
