package linkedlist;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * Created by never on 14-9-14.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        int count = 1;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                count++;
            } else if (count == 1) {
                if (pre == null) {
                    head = p;
                }
                pre = p;
            } else {
                if (pre != null) {
                    pre.next = p.next;
                }
                count = 1;
            }
            p = p.next;
        }
        if (count == 1) {
            if (pre == null) {
                return p;
            } else {
                return head;
            }
        }
        if (pre == null) {
            return null;
        }
        pre.next = null;
        return head;
    }

}
