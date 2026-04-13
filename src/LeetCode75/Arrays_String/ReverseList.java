package LeetCode75.Arrays_String;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head,next = head,prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
