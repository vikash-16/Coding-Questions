package DSAPractice.LinkedList;

import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new AddTwoNumbers().new ListNode(2);
        l1.next = new AddTwoNumbers().new ListNode(4);
        l1.next.next = new AddTwoNumbers().new ListNode(3);
        ListNode l2 = new AddTwoNumbers().new ListNode(5);
        l2.next = new AddTwoNumbers().new ListNode(6);
        l2.next.next = new AddTwoNumbers().new ListNode(4);
        new AddTwoNumbers().addTwoNumbers(l1,l2);

    }
    private class ListNode{
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        int carry = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
             sum = l1.val+l2.val+carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
             sum = (l1.val+carry);
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
             sum = l2.val+carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            l2 = l2.next;
        }
        if(carry == 1) {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        return result.next;
    }

}
