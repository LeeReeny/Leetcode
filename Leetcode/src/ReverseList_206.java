import DataStructure.ListNode;

public class ReverseList_206 {
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode pre = null, cur = head, next = head.next;
        while(next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }

    public ListNode reverseList_1(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
