package linkedlist;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode fakeNode = new ListNode(Integer.MAX_VALUE);
        ListNode tmpNode = fakeNode;
        int carryNum = 0;

        while (l1 != null && l2 != null) {
            ListNode addNode = new ListNode((l1.val + l2.val + carryNum) % 10);
            tmpNode.next = addNode;
            tmpNode = tmpNode.next;
            if (l1.val + l2.val + carryNum >= 10) {
                carryNum = 1;
            } else {
                carryNum = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null && l2 == null) {
            while (l1 != null) {
                if (l1.val + carryNum == 10) {
                    ListNode addNode = new ListNode(0);
                    tmpNode.next = addNode;
                    tmpNode = tmpNode.next;
                    l1 = l1.next;
                    if (l1 == null) {
                        if (carryNum == 1) {
                            ListNode addNode2 = new ListNode(1);
                            tmpNode.next = addNode;
                        }
                    }
                } else {
                    l1.val = l1.val + carryNum;
                    tmpNode.next =  l1;
                    break;
                }
            }

        } else if (l1 == null && l2 != null) {
            while (l2 != null) {
                if (l2.val + carryNum == 10) {
                    ListNode addNode = new ListNode(0);
                    tmpNode.next = addNode;
                    tmpNode = tmpNode.next;
                    l2 = l2.next;
                    if (l2 == null) {
                        if (carryNum == 1) {
                            ListNode addNode2 = new ListNode(1);
                            tmpNode.next = addNode;
                        }
                    }
                } else {
                    l2.val = l2.val + carryNum;
                    tmpNode.next = l2;
                    break;
                }
            }
        } else {
            if (carryNum == 1) {
                ListNode addNode = new ListNode(carryNum);
                tmpNode.next = addNode;
                tmpNode = tmpNode.next;
            }
        }
        return fakeNode.next;
    }
}
