package searchings;

public class binary {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int val = 2;
        System.out.println("Element Found At="+" "+search(arr,val));
    }
    public static int search(int[]arr,int val) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == val) return mid;
            else if(arr[mid] < val){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return 0;
    }
}
