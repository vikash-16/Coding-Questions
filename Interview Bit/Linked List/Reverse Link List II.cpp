Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.



*******solution::


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::reverseBetween(ListNode* A, int B, int C) {
    ListNode * head1 = A;
    ListNode * head2 = NULL;
    ListNode * curr = NULL;
    ListNode * prev = NULL;
    ListNode * Next = NULL;
    int count = 1;
    if(A == NULL || B == C){
        return A;
    }
    if(B == 1) {
        curr = head1;
        count = 0;
        while(count != C ) {
            Next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = Next;
            count++;
        }
        head1->next = curr;
        A = prev;
    } else {
        while(count != B-1) {
            head1 = head1->next;
            count++;
        }
        head2 = head1->next;
        curr = head1->next;
        while(count != C ) {
            Next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = Next;
            count++;
        }
        head1->next = prev;
        head2->next = curr;
    }
    return A;
}

