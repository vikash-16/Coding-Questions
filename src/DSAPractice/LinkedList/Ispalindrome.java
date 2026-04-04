package DSAPractice.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Ispalindrome {
    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode();
        linkedListNode.addElementAtEnd(1);
        linkedListNode.addElementAtEnd(2);
        linkedListNode.addElementAtEnd(1);
//        linkedListNode.addElementAtEnd(1);
        System.out.println(isPalindrome(linkedListNode.head));

    }
    static boolean isPalindrome(LinkedListNode.Node head)
    {
        LinkedListNode.Node rev = reverseList(head);
        LinkedListNode.Node current = head;
        new Ispalindrome().printList(head);
        new Ispalindrome().printList(rev);
        while(current != null && rev != null) {
            if(current.data != rev.data) {
                return false;
            }
            current = head.next;
            rev = rev.next;
        }
        return true;
    }
   static LinkedListNode.Node reverseList(LinkedListNode.Node head) {
        LinkedListNode.Node curr = head;
        LinkedListNode.Node prev = null;
        LinkedListNode.Node Next = null;
        while(curr != null) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }

    private void printList(LinkedListNode.Node head) {
        if (head == null) {
            return;
        }
        LinkedListNode.Node current = head;
        List<LinkedListNode.Node> items = new ArrayList<>();
        while (current != null) {
            items.add(current);
            current = current.next;
        }
        System.out.println(items);
    }
}
