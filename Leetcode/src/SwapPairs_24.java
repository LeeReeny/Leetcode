import DataStructure.ListNode;

public class SwapPairs_24 {
    // 非递归
    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null){
            ListNode start = p.next;
            ListNode end = start.next;
            p.next = end;
            start.next = end.next;
            end.next = start;
            p = start;
        }
        return dummy.next;
    }

    // 递归
    public ListNode swapPairs_1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs_1(next.next);
        next.next = head;
        return next;
    }
}
