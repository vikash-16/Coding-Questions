package DSAPractice.LinkedList;

public class GetMiddleElement {
    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode();
        linkedListNode.addElementAtEnd(1);
        linkedListNode.addElementAtEnd(2);
        linkedListNode.addElementAtEnd(3);
        linkedListNode.addElementAtEnd(4);
        linkedListNode.addElementAtEnd(5);
        System.out.println(getMiddle(linkedListNode.head));
        linkedListNode.printList();
    }
    static int getMiddle(LinkedListNode.Node head)
    {
        LinkedListNode.Node slow = head;
        LinkedListNode.Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
