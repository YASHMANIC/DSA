public class delete_a_node {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        remove(list.head,6);
        list.printList();
    }

    private static Node remove(Node head,int target){
        if(head == null) return head;
        while(head != null){
            if(head.next.data == target){
                if(head.next.next == null) head.next = null;
                else head.next = head.next.next; 
            }
            head = head.next;
        }
        return head;
    }
}
