package Greedy;
import java.util.*;
public class minimumNumberOfCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of coins:-");
        int N = sc.nextInt();
        int [] currency = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        List<Integer>ans = new ArrayList<>();
        for(int i=currency.length - 1;i>=0;i--){
            if(currency[i] > N) continue;
            int currVal = currency[i];
            while(N - currVal >= 0){
                ans.add(currVal);
                N = N-currVal;
                if(N == 0) break;
            }
        }
        System.out.println(ans);
    }
}
