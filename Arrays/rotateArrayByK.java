public class rotateArrayByK {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int k = 3;
        int d = k%arr.length;
        //start
        rotate(arr, 0 , d-1);
        rotate(arr, d, arr.length-1);
        rotate(arr, 0 , arr.length-1);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        //end
        rotate(arr, 0, arr.length-1);
        rotate(arr, 0, d-1);
        rotate(arr, d, arr.length-1);
        System.out.println();
       for(int i=0;i<arr.length;i++) {
        System.out.print(arr[i]+" ");
       }
    }
    public static int[] rotate(int []arr,int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
