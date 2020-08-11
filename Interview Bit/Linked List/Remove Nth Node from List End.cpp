Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.


******solution::



/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::removeNthFromEnd(ListNode* A, int B) {
    ListNode *ptr = A;
    int count = 0;
    while(ptr != NULL) {
        ptr = ptr->next;
        count++;
    }
    if(count == 1) {
        return NULL;
    }
    if(B >= count) {
        A = A->next;
        return A;
    }
    ptr = A;
    count = count-B-1;
    while(count--) {
        ptr = ptr->next;
    }
    ptr->next = ptr->next->next;
    return A;
}

