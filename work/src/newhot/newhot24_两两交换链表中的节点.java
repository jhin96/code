package newhot;

import utils.ListNode;

public class newhot24_两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        pre.next = head;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            // 这里pre.next就是head
            next.next = pre.next;
            pre.next = next;
            pre = head;
            head = head.next;
        }
        return res.next;
    }

}