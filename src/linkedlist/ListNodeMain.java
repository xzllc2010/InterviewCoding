package linkedlist;

import java.util.Stack;

/**
 * Created by never on 14-9-14.
 */
public class ListNodeMain {

    public static void main(String[] args) {
        ListNode head = initList();
        System.out.println(hasCycle(head));
    }

    public static boolean isintersect(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null){
            return false;
        }
        while (head1.next != null){
            head1 = head1.next;
        }
        while (head2.next != null){
            head2 = head2.next;
        }
        return head1 == head2;
    }

    public static boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        if(head.next == null){
            return true;
        }

        ListNode slowPoint = head;
        ListNode fastNode = head;

        while (fastNode != null && fastNode.next != null){
            slowPoint = slowPoint.next;
            fastNode = fastNode.next.next;
            if(fastNode == slowPoint){
                return true;
            }
        }
        return  false;
    }

    public static ListNode mergeSortedListRec(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode retNode = null;
        if (head1.val < head2.val) {
            retNode = head1;
            retNode.next = mergeSortedListRec(head1, head2);
        } else {
            retNode = head2;
            retNode.next = mergeSortedListRec(head1, head2);
        }
        return retNode;
    }

    public static ListNode mergeSortedList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode retNode = null;
        if (head1.val < head2.val) {
            retNode = head1;
            retNode.next = null;
            head1 = head1.next;
        } else {
            retNode = head2;
            retNode.next = null;
            head2 = head2.next;
        }
        ListNode curNode = retNode;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curNode.next = head1;
                head1 = head1.next;
                curNode = curNode.next;
                curNode.next = null;
            } else {
                curNode.next = head2;
                head2 = head2.next;
                curNode = curNode.next;
                curNode.next = null;
            }
        }

        if (head1 != null) {
            curNode.next = head1;
        } else {
            curNode.next = head2;
        }
        return retNode;
    }

    public static void printListReverse(ListNode head) {
        if (head == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }

    public static ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else if (head.next.next == null) {
            return head.next;
        }

        ListNode slowPoint = head;
        ListNode fastPoint = head;

        while (fastPoint.next != null) {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;

            if (fastPoint.next != null) {
                fastPoint = fastPoint.next;
            }
        }
        return slowPoint;
    }

    public static ListNode getKthNode(ListNode head, int k) {
        if (k < 1 || k > getListLength(head) || head == null) {
            return null;
        }
        ListNode slowPoint = head;
        ListNode fastPoint = head;

        while (k > 0) {
            fastPoint = fastPoint.next;
            k--;
        }

        while (fastPoint != null) {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;
        }

        return slowPoint;

    }

    public static ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode secondNode = head.next;
        head.next = null;
        ListNode reverseRest = reverseListRec(secondNode);
        secondNode.next = head;
        return reverseRest;
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode preNode = head;
        ListNode curNode = head.next;
        ListNode nextNode = null;

        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        head.next = null;
        return preNode;

    }

    public static int getListLength(ListNode head) {
        int lenOfList = 0;
        if (head == null) {
            return lenOfList;
        }

        while (head != null) {
            lenOfList++;
            head = head.next;
        }
        return lenOfList;
    }

    public static void displayList(ListNode headNode) {
        if (headNode == null) {
            System.out.print("The linked list is empty!");
        } else {
            while (headNode != null) {
                System.out.print(headNode.val + " ");
                headNode = headNode.next;
            }
        }
    }

    public static ListNode initList() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(11);
        ListNode l7 = new ListNode(13);
        ListNode l8 = new ListNode(15);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        return l1;
    }

    public static ListNode initListA() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(10);
        ListNode l6 = new ListNode(12);
        ListNode l7 = new ListNode(13);
        ListNode l8 = new ListNode(16);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        return l1;
    }

}
