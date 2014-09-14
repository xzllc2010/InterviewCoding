package linkedlist;

/**
 * Created by never on 14-9-14.
 */
public class ListNodeMain {

    public static void main(String[] args) {
        ListNode headNode = initLinkedList();


    }

    public static void PrintLinkedList(ListNode headNode) {
        if (headNode == null) {
            System.out.print("The linked list is empty!");
        } else {
            while (headNode != null) {
                System.out.printf(headNode.val + " ");
                headNode = headNode.next;
            }
        }
    }

    public static ListNode initLinkedList() {
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
        l7.next = l8;

        return l1;
    }

}
