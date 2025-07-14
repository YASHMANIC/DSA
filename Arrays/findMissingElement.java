class findMissingElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9, 0 ,10};
        int n = arr.length;
        boolean ans [] = new boolean[n+1];
        for (int i = 0; i < n; i++) {
                ans[arr[i]] = true;
        }
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i] == false){
                System.out.println(i);
            }
        }
    }
}