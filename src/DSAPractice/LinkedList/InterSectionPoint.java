package DSAPractice.LinkedList;

public class InterSectionPoint {
    /**Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.



     Example 1:

     Input:
     LinkList1 = 3->6->9->common
     LinkList2 = 10->common
     common = 15->30->NULL
     Output: 15
     */
    public static void main(String[] args) {
        LinkedListNode list1 = new LinkedListNode();
        list1.addElementAtEnd(3);
        list1.addElementAtEnd(6);
        list1.addElementAtEnd(9);
        list1.addElementAtEnd(15);
        list1.addElementAtEnd(30);
        list1.printList();
        LinkedListNode list2 = new LinkedListNode();
        list2.addElementAtEnd(10);
        list2.addElementAtEnd(16);
        list2.addElementAtEnd(0);
        list2.printList();
        int point = intersectionPoint(list1.head, list2.head);
        System.out.println(point);
    }

    private static int intersectionPoint(LinkedListNode.Node list1, LinkedListNode.Node list2) {
        int len1 = 0, len2 = 0;
        len1 = countLengthOfList(list1);
        len2 = countLengthOfList(list2);
        int diff = Math.abs(len1-len2);
        if(len1 > len2) {
            while(diff > 0) {
                list1 = list1.next;
                diff--;
            }
        }else {
            while(diff > 0) {
                list2 = list2.next;
                diff--;
            }
        }
        while(list1 != null && list2 != null) {
            if(list1== list2) {
                return list1.data;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return -1;
    }

    private static int countLengthOfList(LinkedListNode.Node list1) {
        LinkedListNode.Node curr = list1;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
