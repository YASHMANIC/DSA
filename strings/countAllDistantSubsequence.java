import java.util.HashMap;

public class countAllDistantSubsequence {
    public static void main(String[] args) {
        String s1 =    "cazbzabcd";
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0 , r = 0 , maxlen = 0 , len = 0;
        while(r < s1.length()){
            if(map.containsKey(s1.charAt(r))){
                if(map.get(s1.charAt(r)) >= l){
                    l = map.get(s1.charAt(r)) + 1;
                }
            }
                len = r - l + 1;
                maxlen = Math.max(maxlen,len);
                map.put(s1.charAt(r), r);
                r++;
        }
        System.out.println(maxlen);
    }
}