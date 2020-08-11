Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.




*******solution::


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::swapPairs(ListNode* A) {
    ListNode * ptr = A;
    if(A == NULL || A->next == NULL) {
        return A;
    }
    while(ptr != NULL && ptr->next != NULL) {
        swap(ptr->next->val, ptr->val);
        ptr = ptr->next->next;
    }
    return A;
}

