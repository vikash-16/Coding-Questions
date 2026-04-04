package DSAPractice.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class InterSectionOfTwoList {
    /**
     * Given two linked lists, the task is to complete the function findIntersection(), that returns the intersection of two linked lists.
     * Each of the two linked list contains distinct node values.
     *
     * Example 1:
     *
     * Input:
     * LinkedList1: 9->6->4->2->3->8
     * LinkedList2: 1->2->8->6
     * Output: 6 2 8
     * */
    public static void main(String[] args) {
        LinkedListNode list1 = new LinkedListNode();
        list1.addElementAtEnd(9);
        list1.addElementAtEnd(6);
        list1.addElementAtEnd(4);
        list1.addElementAtEnd(2);
        list1.addElementAtEnd(3);
        list1.addElementAtEnd(8);
        LinkedListNode list2 = new LinkedListNode();
        list2.addElementAtEnd(1);
        list2.addElementAtEnd(2);
        list2.addElementAtEnd(6);
        list2.addElementAtEnd(8);
        LinkedListNode.Node intersection = findIntersection(list1.head, list2.head);
        while(intersection != null) {
            System.out.println(intersection.data);
            intersection = intersection.next;
        }

    }
    public static LinkedListNode.Node findIntersection(LinkedListNode.Node head1, LinkedListNode.Node head2)
    {
        Set<Integer>set = new HashSet<>();
        LinkedListNode.Node h2 = head2;
        while(h2 != null) {
            set.add(h2.data);
            h2 = h2.next;
        }
        LinkedListNode.Node h1 = head1;
        LinkedListNode result = new LinkedListNode();
        while(h1 != null) {
            if(set.contains(h1.data)) {
                result.addElementAtEnd(h1.data);
            }
            h1 = h1.next;
        }
        return result.head;
    }
}
