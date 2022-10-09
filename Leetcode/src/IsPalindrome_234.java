import DataStructure.ListNode;

public class IsPalindrome_234 {
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverseList(slow.next);
        while(slow!= null){
            if(slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = null, cur = head, next = head.next;
        while(next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        return pre;
    }
}
