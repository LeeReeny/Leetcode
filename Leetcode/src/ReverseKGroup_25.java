import DataStructure.ListNode;

public class ReverseKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre  = dummy, end = dummy;
        while(end.next != null){
            for(int i = 0; i < k && end != null; ++i) end = end.next;
            if(end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
