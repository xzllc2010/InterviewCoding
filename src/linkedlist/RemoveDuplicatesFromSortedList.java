package linkedlist;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.For example, Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * Created by never on 14-9-14.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while(fastNode != null){
            if(fastNode.val == slowNode.val){
                fastNode = fastNode.next;
                slowNode.next = fastNode;
            }else{
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }
        }
        return head;
    }

}
