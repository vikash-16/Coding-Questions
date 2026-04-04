package DSAPractice.LinkedList;

public class ReverseLinkedList_II {
    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode();
        linkedListNode.addElementAtEnd(1);
        linkedListNode.addElementAtEnd(2);
        linkedListNode.addElementAtEnd(3);
//        linkedListNode.addElementAtEnd(4);
//        linkedListNode.addElementAtEnd(5);
        new ReverseLinkedList_II().reverseBetween(linkedListNode.head,1,2);
//        linkedListNode.printList();
    }
    public LinkedListNode.Node reverseBetween(LinkedListNode.Node head ,int left, int right) {
        if(head == null || head.next == null || left == right) {
            return head;
        }
        LinkedListNode.Node curr = head;
        LinkedListNode.Node prev = null;
        LinkedListNode.Node next = null;
        LinkedListNode.Node temp = null;
        LinkedListNode.Node temp2 = null;
        int nodeToCover = right-left+1;
        while (curr != null && left > 1) {
            temp = curr;
            curr = curr.next;
            left--;
        }
        temp2 = curr;
        while(curr != null && nodeToCover > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            nodeToCover--;
        }

        if(temp == null ) {
            return  prev;
        }
        temp.next = prev;
        temp2.next = curr;
        return head;
    }
}
