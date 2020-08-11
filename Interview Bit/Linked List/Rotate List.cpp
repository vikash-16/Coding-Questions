Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.



******solution::


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::rotateRight(ListNode* A, int B) {
    int count = 0;
    ListNode * ptr1 = A;
    ListNode * ptr2 = NULL;
    while(ptr1 != NULL) {
        ptr1 = ptr1->next;
        count++;
    }
    if(B == 1 && count ==1) {
        return A;
    }
    B = B%count;
    if(B == 0) {
        return A;
    }
    count = count-B-1;
    ptr1 = A;
    while(count--) {
        ptr1 = ptr1->next;
    }
    ptr2 = ptr1->next;
    ptr1->next = NULL;
    ptr1 = ptr2;
    while(ptr2->next != NULL) {
        ptr2 = ptr2->next;
    }
    ptr2->next = A;
    A = ptr1;
    return A;
}

