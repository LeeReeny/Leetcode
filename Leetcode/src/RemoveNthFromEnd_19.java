import DataStructure.ListNode;

public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null || head.next == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = head, pre = dummy;
        while(--n > 0){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }
}
