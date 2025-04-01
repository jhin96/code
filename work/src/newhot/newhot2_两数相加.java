package newhot;

import utils.ListNode;

public class newhot2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null | l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode node = new ListNode(-1);
        ListNode res = node;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 处理l1和l2
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            int value = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            node.next = new ListNode(value);
            node = node.next;
        }
        if (carry != 0) {
            node.next = new ListNode(carry);
        }
        return res.next;
    }

}