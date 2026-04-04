package DSAPractice.LinkedList;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        LinkedListNode list1 = new LinkedListNode();
        list1.addElementAtEnd(5);
        list1.addElementAtEnd(10);
        list1.addElementAtEnd(15);
        list1.addElementAtEnd(20);
        LinkedListNode list2 = new LinkedListNode();
        list2.addElementAtEnd(2);
        list2.addElementAtEnd(3);
        list2.addElementAtEnd(20);
        LinkedListNode.Node node = sortedMerge(list1.head, list2.head);
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }
    static LinkedListNode.Node sortedMerge(LinkedListNode.Node head1, LinkedListNode.Node head2) {
        if(head1 == null) {
            return head2;
        }else if(head2 == null) {
            return head1;
        }else if(head1.data < head2.data) {
            head1.next = sortedMerge(head1.next,head2);
            return head1;
        }else {
            head2.next = sortedMerge(head1,head2.next);
            return head2;
        }

    }
}
