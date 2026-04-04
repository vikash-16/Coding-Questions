package DSAPractice.LinkedList;

public class PairSum {
    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();
        list.addElementAtEnd(4);
        list.addElementAtEnd(2);
        list.addElementAtEnd(2);
        list.addElementAtEnd(3);
        int i = pairSum(list.head);
        System.out.println(i);
    }
    public static int pairSum(LinkedListNode.Node head) {
        LinkedListNode.Node slow = head;
        LinkedListNode.Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode.Node mid = reverseRecursive(slow);
        LinkedListNode.Node ptr1 = head;
        LinkedListNode.Node ptr2 = mid;
        int minSum = Integer.MIN_VALUE;
        fast = head;
        while (ptr2 != null) {
            minSum = Math.max(ptr1.data+ptr2.data,minSum);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return minSum;
    }
    private static LinkedListNode.Node reverseRecursive(LinkedListNode.Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        LinkedListNode.Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }}
