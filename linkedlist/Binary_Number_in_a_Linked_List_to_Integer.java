public class Binary_Number_in_a_Linked_List_to_Integer {
    public static void main(String[] args) {
        // Example usage
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(0);
        list.add(1);
        System.out.println(getDecimalValue(list.head)); // Output: 5
    }

    public static int getDecimalValue(Node head) {
        Node curr = head;
        int result = 0;
        while (curr != null) {
            // result = (result << 1) | curr.data;
            result = result * 2 + curr.data;
            curr = curr.next;
        }
        return result;
    }
    
}
