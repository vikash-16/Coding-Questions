package LeetCode75.Arrays_String;

public class OddEvenList {
    public static void main(String[] args) {
        OddEvenList oddEvenList = new OddEvenList();

    }
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head,even = odd.next, temp = even;
        while (odd != null && odd.next != null && even != null && even.next!= null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = even;
        return odd;
    }
}
