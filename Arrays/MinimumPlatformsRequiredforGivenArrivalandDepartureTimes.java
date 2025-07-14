
import java.util.Arrays;

public class MinimumPlatformsRequiredforGivenArrivalandDepartureTimes {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count =0 ,maxcount = 0;
        int i=0 ,j=0;
        while(i<arr.length){
            if(arr[i]<dep[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            maxcount = Math.max(maxcount , count);
        }
        System.out.println(maxcount);
    }
}