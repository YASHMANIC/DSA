package Greedy;
import java.util.*;
public class ActivitySelectionProblem {

    static class Job{
        int start;
        int end;
        public Job(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    static class JobComparator implements Comparator<Job>{
        public int compare(Job o1, Job o2){
            if(o1.end > o2.end) return 1;
            else if(o1.end < o2.end) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of activities: ");
         n = scanner.nextInt();
        Job[] jobs = new Job[n];
        System.out.println("Enter Start and End of activities: ");
        for(int i=0;i<n;i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            jobs[i] = new Job(start,end);
        }
        Arrays.sort(jobs, new JobComparator());
        for(int i=0;i<n;i++){
            System.out.println(jobs[i].start + " " + jobs[i].end);
        }
        int take =0;
        int currEnd = jobs[0].end;
        for(int i=0;i<jobs.length;i++){
            if(jobs[i].start > currEnd){
                take ++;
                currEnd = jobs[i].end;
            }
        }
        System.out.println(take);
    }
}
