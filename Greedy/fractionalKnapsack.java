package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {
   static class Item {
        int value;
        int weight;
        public Item(int value, int weight) {
            this.weight = weight;
            this.value = value;
        }
    }

        static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item t1, Item t2) {
           double r1 = (double) t1.value / t1.weight;
           double r2 = (double) t2.value / t2.weight;
           if(r1 > r2) return -1;
           else if(r1 < r2) return 1;
           else return 0;
        }
    }

    public static void main(String[] args) {
       int n = 3 , weight= 50;
        Item[] items = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionaKnapsack(items,weight,n);
        System.out.println(ans);
    }

    private static double fractionaKnapsack(Item[] items, int weight, int n) {
        Arrays.sort(items,new ItemComparator());
        int currentWeight = 0;
        double currentValue = 0;
        for(int i = 0;i<n;i++){
            if(currentWeight + items[i].weight <= weight){
                currentWeight += items[i].weight;
                currentValue += items[i].value;
            }
            else{
                int remain = weight - currentWeight;
               currentValue += ((double) items[i].value / (double) items[i].weight) * (double) remain;
               break;
            }
        }
        return currentValue;
   }
}
