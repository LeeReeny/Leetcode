import DataStructure.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class DeleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null) return head;
        HashSet<Integer> record = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        while(head != null){
            if(record.contains(head.val)){
                pre.next = head.next;
            }
            else{
                record.add(head.val);
                pre = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates_1(ListNode head){
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates_1(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }

    public ListNode deleteDuplicates_2(ListNode head){
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
        return head;
    }
}
