package leetcode100;

import utils.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot23_合并K个升序链表 {

    /**
     * 分治法合并k个升序链表
     * 空间复杂度：O(logk)，递归栈深度
     * 时间复杂度：O(nlogk)，n为所有链表节点总数
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    public ListNode helper(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return mergeKTwoListNode(left, right);
    }

    /**
     * 合并两个链表
     *
     * @param node1
     * @param node2
     * @return
     */
    public ListNode mergeKTwoListNode(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        if (node1.val < node2.val) {
            node1.next = mergeKTwoListNode(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeKTwoListNode(node1, node2.next);
            return node2;
        }
    }

}
