Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.



*****solution::


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::partition(ListNode* A, int B) {
    if(A == NULL || A->next == NULL) {
        return A;
    }
    ListNode * dummy = new ListNode(-1);
    ListNode * ptr = dummy;
    ListNode * head = A;
    while(head != NULL) {
        if(head->val < B) {
            ListNode * temp = new ListNode(head->val);
            ptr->next = temp;
            ptr = temp;
        }
        head = head->next;
    }
    head = A;
    while(head != NULL) {
        if(head->val >= B) {
            ListNode * temp = new ListNode(head->val);
            ptr->next = temp;
            ptr = temp;
        }
    head = head->next;
    }
    ptr->next = NULL;
    return dummy->next;
}

