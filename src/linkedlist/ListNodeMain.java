package linkedlist;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by never on 14-9-14.
 */
public class ListNodeMain {

    public static void main(String[] args) {
        ListNode headNode = initList();
        printListReverse(headNode);

    }

    public static ListNode mergeSortedList(ListNode head1, ListNode head2){

    }

    public static void printListReverse(ListNode head){
        if(head == null){
            return;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null){
            stack.add(head);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().val);
        }
    }

    public static ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }else if(head.next.next == null){
            return head.next;
        }

        ListNode slowPoint = head;
        ListNode fastPoint = head;

        while (fastPoint.next != null) {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;

            if(fastPoint.next != null){
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
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        //l7.next = l8;

        return l1;
    }

}
