package LeetCode75.Arrays_String;

import java.util.List;

public class DeleteMiddleNode {
    static ListNode head = null;
    public static void main(String[] args) {
        int[] lst = {1, 3, 4, 7, 1, 2, 6};
        DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
        for(int val : lst) {
            deleteMiddleNode.BuildLinkedList(val);
        }
        deleteMiddleNode.deleteMiddle(head);
        deleteMiddleNode.printLinkedList(head);

    }

    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode f = head,s = head,p = head;
        while (f!= null && f.next != null) {
            p = s;
            f = f.next.next;
            s = s.next;
        }
        p.next = s.next;
        return head;
    }
    public void BuildLinkedList(int val) {
        if(head == null) {
            head = new ListNode(val);
        }else {
            ListNode temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
        }
    }
    public void printLinkedList(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val+"->");
            head = head.next;
        }
        System.out.println(head.val);
    }
}
