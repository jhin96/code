package offer;

import utils.ListNode;

/**
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 *
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=23449&sourceUrl=
 *
 */
public class offer23_链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 直接找入口
                while (slow != pHead) {
                    slow = slow.next;
                    pHead = pHead.next;
                }
                return slow;
            }
        }
        return null;
    }

}
