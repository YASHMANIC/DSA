import java.util.ArrayList;
import java.util.List;
public class check_palindrome {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(10);
        System.out.println(check(list.head));
    }
    private static Boolean check(Node head){
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.data);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while(left <= right && list.get(left) == list.get(right)){
            left++;
            right--;
        }
        return left >= right;
    }
}
 