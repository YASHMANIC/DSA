public class removeDuplicatedFromSorted { 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(5);
        removeDuplicates(list.head);
        list.printList();
        
    }   
    static Node removeDuplicates(Node head){
        Node curr = head;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data) curr.next = curr.next.next;
            else curr = curr.next;
        }
        return head;
    } 
}