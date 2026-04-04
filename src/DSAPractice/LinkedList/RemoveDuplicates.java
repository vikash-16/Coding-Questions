package DSAPractice.LinkedList;

import java.util.List;
import java.util.function.Predicate;

public class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode();
        linkedListNode.addElementAtEnd(1);
        linkedListNode.addElementAtEnd(1);
        linkedListNode.addElementAtEnd(3);
        linkedListNode.addElementAtEnd(3);
        linkedListNode.addElementAtEnd(5);
        System.out.println(new RemoveDuplicates().deleteDuplicates(linkedListNode.head));
        linkedListNode.printList();

    }
    public LinkedListNode.Node deleteDuplicates(LinkedListNode.Node node) {
        if(node == null || node.next == null) {
            return node;
        }
        LinkedListNode.Node curr = node;
        while (curr != null && curr.next != null) {
            if(curr.data == curr.next.data) {
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return node;
    }
}
