Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.



*****solution::

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::deleteDuplicates(ListNode* A) {
    ListNode * head = A;
    if(head->next == NULL) {
        return head;
    }else {
        while(head->next != NULL) {
            if(head->val == head->next->val) {
                head->next = head->next->next;
            }else {
                head = head->next;
            }
        }
    }
    return A;
}

