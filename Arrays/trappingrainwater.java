public class trappingrainwater {
    public static void main(String[] args) {
        int arr[] = {4,2,0,3,2,5};
        int n = arr.length , res = 0;
        int lmax = 0 , rmax = 0;
        int l =0 , r =n-1;
        while(l <= r){
            if(arr[l]<=arr[r]){
                if (arr[l] >= lmax) lmax = arr[l];
                else res = res + lmax - arr[l];
                l++;
        }else{
            if (arr[r] >= rmax) rmax = arr[r];
                else res = res + rmax - arr[r];
                r--;
        }
    }
    System.out.println(res);
}
}
