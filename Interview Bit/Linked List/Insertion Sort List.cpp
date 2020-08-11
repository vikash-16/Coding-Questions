Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3



******solution::


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::insertionSortList(ListNode* A) {
    if(A == NULL || A->next == NULL) {
        return A;
    }
    ListNode * ptr1, *ptr2 = NULL;
    ptr1 = A;
    int temp = 0;
    while(ptr1 != NULL) {
        ptr2 = A;
        while(ptr2 != ptr1) {
            if(ptr2->val >= ptr1->val) {
                temp = ptr2->val;
                ptr2->val = ptr1->val;
                ptr1->val = temp;
                ptr2 = ptr2->next;

            }else {
                ptr2 = ptr2->next;
            }
        }
        ptr1 = ptr1->next;
    }
    return A;
}

