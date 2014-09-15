package linkedlist;

/**
 * Created by never on 14-9-15.
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode preNode = head;
        ListNode curNode = head.next;
        ListNode postNode = null;

        while (curNode != null){
            postNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = postNode;
        }

        head.next = null;
        head = preNode;

        return head;

    }
}
