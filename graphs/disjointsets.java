import java.util.*;
public class disjointsets {
    public static void main(String[] args) {
        Innerdisjointsets ds = new Innerdisjointsets(7);
        ds.rankByUnion(1, 2);
        ds.rankByUnion(2, 3);
        ds.rankByUnion(4, 5);
        ds.rankByUnion(6, 7);
        ds.rankByUnion(5, 6);
        if(ds.findPair(3) == ds.findPair(7)){
            System.out.println("Same");
        }else System.out.println("Not Same");
        ds.rankByUnion(3, 7);
        if(ds.findPair(3) == ds.findPair(7)){
            System.out.println("Same");
        }else System.out.println("Not Same");
    }
}
class Innerdisjointsets {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    Innerdisjointsets(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    int findPair(int node){
        if (node == parent.get(node)) return node;
        int ulp = findPair(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    void rankByUnion(int u,int v){
        int ulp_u = findPair(u);
        int ulp_v = findPair(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        }
        else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
}
