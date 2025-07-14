public class MaximumSubArrayProduct {
    public static void main(String[] args) {
        int arr [] = {0, -1, 3, 100, 70, 50 };
        int ans = Integer.MIN_VALUE;
        int suff = 1 , pref = 1;
        for (int i = 0; i < arr.length; i++) {
            if(suff == 0) suff = 1;
            if(pref == 0) pref = 1;
            pref = pref * arr[i];
            suff = suff * arr[arr.length -i - 1];
            ans = Math.max(ans , Math.max(pref , suff));
        }
        System.out.println(ans);
    }
}