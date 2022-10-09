import DataStructure.ListNode;

public class RotateRight_61 {
    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null) return head;
        int len = 0;
        ListNode cnt = head;
        while(cnt != null){
            ++len;
            cnt = cnt.next;
        }
        k %= len;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(k-- > 0){
            ListNode pre = null, node = head;
            while(node.next != null){
                pre = node;
                node = node.next;
            }
            pre.next = null;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}
