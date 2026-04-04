Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.




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
    if(head == NULL || head->next == NULL) {
        return head;
    }
    ListNode * curr = head;
    ListNode * prev = NULL;
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
 ListNode* Solution::reorderList(ListNode* A) {
    if(A==NULL || A->next==NULL)
        return A;
    ListNode * slow = A;
    ListNode * fast = A;
    ListNode * head1 = A;
    while(fast != NULL && fast->next != NULL) {
        fast = fast->next->next;
        slow = slow->next;
    }
    ListNode * head2 = reverse(slow);
    ListNode *p1,*p2,*q1,*q2 = NULL;
        p1 = head1;
        p2 = head2;
        q1 = p1->next;
        q2 = p2->next;
    while(q2 != NULL) {
        p1->next = p2;
        p2->next = q1;
        p1 = q1;
        p2 = q2;
        q1 = q1->next;
        q2 = q2->next;
    }
    return A;

 }
/*ListNode * reverse(ListNode * head) {
    if(head == NULL || head->next == NULL) {
        return head;
    }
    ListNode * curr = head;
    ListNode * prev = NULL;
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
ListNode* Solution::reorderList(ListNode* A) {
    if(A == NULL || A->next == NULL) {
        return A;
    }
    ListNode * temp = A;
    while(temp->next != NULL) {
        temp->next = reverse(temp->next);
        temp = temp->next;
    }
    return A;
}*/

