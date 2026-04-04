package DSAPractice.LinkedList;

public class ReverseLinkedList {

    /**Given a linked list of N nodes. The task is to reverse this list.

     Example 1:

     Input:
     LinkedList: 1->2->3->4->5->6
     Output: 6 5 4 3 2 1
     Explanation: After reversing the list,
     elements are 6->5->4->3->2->1.
     */
    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();
        list.addElementAtEnd(1);
        list.addElementAtEnd(2);
        list.addElementAtEnd(3);
        list.addElementAtEnd(4);
        list.printList();
//        LinkedListNode.Node node = reverseIterative(list.head);
        LinkedListNode.Node node = reverseRecursive(list.head);

//        list.head = node;
        list.printList();
    }

    /** Recursive Method for Reverse LinkedList **/
    private static LinkedListNode.Node reverseRecursive(LinkedListNode.Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkedListNode.Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /** Iterative Method for Reverse LinkedList */
    private static LinkedListNode.Node reverseIterative(LinkedListNode.Node head) {
        LinkedListNode.Node curr = head;
        LinkedListNode.Node prev = null;
        LinkedListNode.Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
