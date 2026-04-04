Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.



******solution::


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode * reverse(ListNode * head) {
    ListNode * prev = NULL;
    ListNode * curr = head;
    ListNode * Next = NULL;
    while(curr != NULL) {
        Next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = Next;
    }
    head = prev;
    return head;
}
int Solution::lPalin(ListNode* A) {
    if(A==NULL || A->next==NULL){
        return 1;
    }
    ListNode * slow = A;
    ListNode * fast = A;
    while(fast != NULL && fast->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
    }
    ListNode * ptr = reverse(slow);

    while(ptr!= NULL) {
        if(ptr->val != A->val) {
            return 0;
        }
        ptr = ptr->next;
        A = A->next;
    }
    return 1;
}

