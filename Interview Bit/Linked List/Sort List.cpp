Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5



****solution::


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode * mergesort(ListNode * head1, ListNode *head2) {
    if(head1 == NULL) {
        return head2;
    }
    if(head2 == NULL) {
        return head1;
    }
    if(head1->val <= head2->val) {
        head1->next = mergesort(head1->next,head2);
        return head1;
    } else {
        head2->next = mergesort(head1, head2->next);
        return head2;
    }
}
ListNode* Solution::sortList(ListNode* A) {
    if(A == NULL || A->next == NULL) {
        return A;
    }
    ListNode *slow = A;
    ListNode * fast = A;
    ListNode * prev = NULL;
    while(fast != NULL && fast->next != NULL) {
        prev = slow;
        fast = fast->next->next;
        slow = slow->next;
    }
    prev->next = NULL;
    A = sortList(A);
    slow = sortList(slow);
    return mergesort(A,slow);
}

