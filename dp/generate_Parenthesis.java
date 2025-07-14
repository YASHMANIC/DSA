import java.util.*;

public class generate_Parenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of pairs");
        int n = sc.nextInt();
        List<String> res = new ArrayList<>();
        backTrack(0, 0, n, "", res);
        for(String s : res){
            System.out.println(s);
        }
    }
    private static void backTrack(int o,int c,int n,String curr,List<String>res){
        if(c == n){
            res.add(curr);
        }
        if(o > c) backTrack(o, c+1, n, curr+")", res);
        if(o < n) backTrack(o+1, c, n, curr+"(", res);
    } 
}
