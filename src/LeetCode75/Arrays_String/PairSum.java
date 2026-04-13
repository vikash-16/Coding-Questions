package LeetCode75.Arrays_String;

public class PairSum {
    static ListNode head  = null;
    public static void main(String[] args) {
        int[] ints = {5, 4, 2, 1};
        for(int n: ints) {
            if(head == null) {
                head = new ListNode(n);
            }else {
                ListNode temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new ListNode(n);
            }
        }
        PairSum pairSum = new PairSum();
        System.out.println(pairSum.pairSum(head));

    }
    public int pairSum(ListNode head) {
        ListNode s = head,f = head,ptr1 = head,ptr2 = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ptr2 = reverseList(s);
        int maxSum = Integer.MIN_VALUE;
        while (ptr2 != null) {
            maxSum = Math.max(maxSum,ptr1.val+ptr2.val);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return maxSum;
    }

    private ListNode reverseList(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode newHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}
