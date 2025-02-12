package leetcode100;

import utils.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * https://leetcode.cn/problems/reverse-linked-list/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class hot206_反转链表 {

    /**
     * 时间复杂度：O(n)，遍历一次
     * 空间负责度：O(1)，一个辅助指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
