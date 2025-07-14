package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaximumLengthChainofPairs {

    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            if(p1.second < p2.second) return -1;
            else if(p1.second == p2.second) return 0;
            else return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        Pair [] p = new Pair[n];
        System.out.println("Enter the elements in the array");
        for (int i = 0; i < n; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            p[i] = new Pair(first,second);
        }
        Arrays.sort(p, new PairComparator());
        for (int i = 0; i < n; i++) {
            System.out.println(p[i].first + " " + p[i].second);
        }
        int count = 1;
        int end = p[0].second;
        for (int i = 1; i < n; i++) {
            if(p[i].first > end){
                end = p[i].second;
                count++;
            }
        }
        System.out.println(count);
    }
}
