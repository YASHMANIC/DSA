package searchings;

public class ternary {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int tar = 9;
        System.out.println("Element Found At="+" "+search(arr,tar));
    }
    public static int search(int[]arr,int tar){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int m1 = start + (end - start) / 3; 
            int m2 = end - (end - start) / 3;
            if (arr[m1] == tar) return m1;
            if (arr[m2] == tar) return m2;
            if(tar < arr[m1]) end = m1 - 1;
            else if(tar > arr[m2]) start = m2 + 1;
            else{
                start = m1+1;
                 end = m2-1;
            }
        }
        return 0;
    }
}
