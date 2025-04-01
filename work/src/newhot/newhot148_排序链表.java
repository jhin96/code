package newhot;

import utils.ListNode;

public class newhot148_排序链表 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针将链表分成两部分
        ListNode slow = head;
        // 这样才能均分
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headA = slow.next;
        slow.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(headA);
        // 合并两个排序链表
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return pre.next;
    }

}