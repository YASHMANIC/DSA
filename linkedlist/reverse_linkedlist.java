public class reverse_linkedlist {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Original List:");
        list.printList();
        System.out.println("Reversed List:");
        reverse(list);
        list.printList();
    }
    public static Node reverse(LinkedList list){
        if(list.head == null) return null;
        if(list.head.next == null) return list.head;
        var prev = list.head;
        var curr = list.head.next;
        while(curr != null){
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head.next = null;
        list.head = prev;
        return list.head;
    }
}
