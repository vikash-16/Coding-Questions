Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

 NOTE : The length of the list is divisible by K
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.



*****solution::



/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::reverseList(ListNode* A, int B) {
    if(A == NULL || A->next == NULL){
        return A;
    }
    if(B == 1) {
        return A;
    }
    ListNode * curr = A;
    ListNode * prev = NULL;
    ListNode * Next = NULL;
    int count = 0;
    while(curr != NULL && count < B) {
        Next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = Next;
        count++;
    }
    if(Next != NULL){
        A->next = reverseList(Next,B);
    }
    return prev;
}

