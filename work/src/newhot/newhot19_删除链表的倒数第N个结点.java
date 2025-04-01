package newhot;

import utils.ListNode;

public class newhot19_删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode node = pre;
        // 先移动n位
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        // 删除节点
        while (head != null) {
            head = head.next;
            node = node.next;
        }
        if (node.next != null) {
            node.next = node.next.next;
        }
        return pre.next;
    }

}