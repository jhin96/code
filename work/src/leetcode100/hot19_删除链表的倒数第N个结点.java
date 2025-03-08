package leetcode100;

import utils.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot19_删除链表的倒数第N个结点 {

    /**
     * 定义一个前置节点，head先走n步
     * 时间复杂度：O(n)
     * 空间复杂度O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode tmp = pre;
        while (n > 0 && head != null) {
            head = head.next;
            n--;
        }
        // 找到倒数第n个节点的前一个节点
        while (head != null) {
            head = head.next;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return pre.next;
    }

}
