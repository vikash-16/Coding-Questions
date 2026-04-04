package TopInterView;

import java.util.List;

public class Practice {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(1);
        System.out.println(checkListIsPalindromeOrNot(listNode));
    }

    private static Boolean checkListIsPalindromeOrNot(ListNode listNode) {
        if(listNode == null || listNode.next == null) return true;
        ListNode slow = listNode;
        ListNode fast = listNode;
        ListNode prev = listNode;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode listNode1 = reverseList(slow);
        while (listNode != prev && listNode1 != null) {
            if(listNode.val  != listNode1.val) {
                return false;
            }
            listNode = listNode.next;
            listNode1 = listNode.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode listNode) {
        if(listNode == null || listNode.next == null) return listNode;
        ListNode prev = null;
        ListNode cur = listNode;
        ListNode Next = null;
        while (cur != null) {
            Next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = Next;
        }
        return prev;
    }
}
