import java.util.*;

public class combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>>res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        bachTrack(1, res, comb, n, k);
        for (List<Integer> combination : res) {
            System.out.println(combination);
        }
    }
    private static void bachTrack(int start,List<List<Integer>>res,List<Integer> comb,int n,int k){
        if(comb.size() == k){
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int num=start;num<=n;num++){
            comb.add(num);
            bachTrack(num+1, res, comb, n, k);
            comb.remove(comb.size() - 1);
        }
    }
}
