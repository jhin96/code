package newhot;

import utils.ListNode;

public class newhot25_K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 计算链表长度
        ListNode tmp = head;
        int n = 0;
        while (tmp != null) {
            tmp = tmp.next;
            n++;
        }

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        cur.next = head;
        // 翻转次数
        for (int i = 0; i < n / k; i++) {
            // k个翻转
            for (int j = 0; j < k - 1; j++) {
                ListNode next = head.next;
                head.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = head;
            head = head.next;
        }
        return cur.next;
    }

}