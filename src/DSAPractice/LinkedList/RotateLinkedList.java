package DSAPractice.LinkedList;

public class RotateLinkedList {
    /**Given a singly linked list of size N. The task is to left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.

     Example 1:

     Input:
     N = 5
     value[] = {2, 4, 7, 8, 9}
     k = 3
     Output: 8 9 2 4 7
     Explanation:
     Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
     Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
     Rotate 3: 8 -> 9 -> 2 -> 4 -> 7
     */
    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();
        list.addElementAtEnd(2);
        list.addElementAtEnd(4);
        list.addElementAtEnd(7);
        list.addElementAtEnd(8);
        list.addElementAtEnd(9);
        list.printList();
        LinkedListNode.Node node = rotateLinkedList(list.head, 4);
        list.head = node;
        list.printList();
    }

    private static LinkedListNode.Node rotateLinkedList(LinkedListNode.Node head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkedListNode.Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        while(k > 0) {
            curr = curr.next;
            k--;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}
