public class equilibriumpoint {
    public static void main(String[] args) {
        int [] arr = {1,7,3,6,5,6};
        //[1,8,11,17,22,28]
        int pre[] = new int[arr.length];
        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre[i] = pre[i-1] + arr[i];
        }
        int sum = pre[pre.length - 1];
        for (int i = 1; i < pre.length - 1; i++) {
            int rsum = sum - pre[i];
            int lsum = pre[i] - arr[i] ;
            if(lsum == rsum){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
