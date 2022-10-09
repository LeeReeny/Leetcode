import DataStructure.ListNode;

public class SortList_148 {
    public class Solution{
        public ListNode sortList(ListNode head){
            if(head == null) return head;
            int length = 0;
            ListNode nd = head;
            while(nd != null){
                length += 1;
                nd = nd.next;
            }
            ListNode dummyhead = new ListNode (0);
            dummyhead.next = head;

            for(int sublen = 1; sublen < length; sublen <<= 1){ //位运算对java来说更快
                ListNode prev = dummyhead;
                ListNode cur = dummyhead.next;  //记录拆分链表的位置
                while(cur != null){
                    ListNode head1 = cur; //第一个子链表开头
                    for(int i = 1; i < sublen && cur != null && cur.next != null; i++){
                        cur = cur.next;
                    }

                    ListNode head2 = cur.next;  //找到第二个链表的头
                    cur.next = null;  //将两个链表断开
                    cur = head2;  // 将拆分位置重新赋给cur
                    for(int i = 1; i < sublen && cur != null && cur.next != null; i++){
                        cur = cur.next;
                    }

                    ListNode nxt = null; //断开
                    if(cur != null){
                        nxt = cur.next;
                        cur.next = null;
                    }

                    ListNode merged = merge(head1, head2);
                    prev.next = merged;
                    while(prev.next != null){
                        prev = prev.next;
                    }
                    cur = nxt;
                }
            }
            return dummyhead.next;
        }
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummyhead = new ListNode(0);
        ListNode tmp = dummyhead, tmp1 = head1, tmp2 = head2;
        while(tmp1 != null && tmp2 != null){
            if(tmp1.val <= tmp2.val){
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }
            else{
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = tmp1 == null ? tmp2 : tmp1;
        return dummyhead.next;
    }
}

//下面实现的插入排序的时间复杂度是O(n^2)，超过O(nlogn)的时间限制
class Solution{
    public ListNode sortList(ListNode head){
        if(head == null) return null; // 链表为空
        if(head.next == null) return head; //只有一个头节点
        else if(head.next.next == null){  //长度为2
            ListNode tmp = head.next;
            if(tmp.val < head.val){
                head.next = null;
                tmp.next = head;
                head = tmp;
            }
            return head;
        }
        ListNode cur = head;
        while(cur.next != null){
            ListNode cmp = cur.next;
            if(cmp.val <= head.val){
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = head;
                head = tmp;
            }
            ListNode vis = head;
            while(vis != cur){
                if(vis.next.val > cmp.val){
                    ListNode tmp = cmp;
                    cur.next = cmp.next;
                    tmp.next = vis.next;
                    vis.next = tmp;
                }
                vis = vis.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
