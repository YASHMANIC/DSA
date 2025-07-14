import java.util.Arrays;

public class largestNumber {
    public static void main(String[] args) {
        String [] s = {"0","1","2","3","4","5","6","7","8","9"};
        Arrays.sort(s, (a,b) -> (b+a).compareTo(a+b));
        String ans = "";
        for(String i : s){
            ans += i;
        }
        System.out.println(ans);
    }
}
