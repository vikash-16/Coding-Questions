package DSAPractice.LinkedList;

import javax.swing.plaf.IconUIResource;

public class ReverseLinkedListInGroup {
    /**Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed (See Example 2 for clarification).

     Example 1:

     Input:
     LinkedList: 1->2->2->4->5->6->7->8
     K = 4
     Output: 4 2 2 1 8 7 6 5
     Explanation:
     The first 4 elements 1,2,2,4 are reversed first
     and then the next 4 elements 5,6,7,8. Hence, the
     resultant linked list is 4->2->2->1->8->7->6->5.
     */
    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();
        list.addElementAtEnd(1);
        list.addElementAtEnd(2);
        list.addElementAtEnd(3);
        list.addElementAtEnd(4);
        list.addElementAtEnd(5);
        list.addElementAtEnd(6);
        list.addElementAtEnd(7);
        list.addElementAtEnd(8);
        list.printList();
        LinkedListNode.Node node = reverseListInGroup(list.head, 2);
        list.head = node;
        list.printList();
    }

    private static LinkedListNode.Node reverseListInGroup(LinkedListNode.Node head, int k) {
        LinkedListNode.Node prev = null;
        LinkedListNode.Node curr = head;
        LinkedListNode.Node next = null;
        int count = 0;
        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null) {
            head.next = reverseListInGroup(next,k);
        }
        return prev;
    }
}
