package leetcode100;

import utils.ListNode;

/**
 * 给你链表的头结点head，请将其按升序排列并返回排序后的链表 。
 *
 * https://leetcode.cn/problems/sort-list/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot148_排序链表 {

    /**
     * 归并排序，先拆开，后面一个个节点合并
     * 空间复杂度O(logN)取决于递归栈的深度，平均深度logN
     * 时间复杂度O(nlogN)递归时间为logN，后续拼接时间为n
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 用快慢指针将链表一分为二
        // 奇数slow在中点，偶数slow在中间偏左的节点
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开链表(必须断开，不然后续指针就乱了)
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归进行拆分
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 合并拆分的两个链表
        ListNode cur = new ListNode(0);
        ListNode res = cur;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        // 处理最后可能剩下的节点
        cur.next = left == null ? right : left;
        return res.next;
    }

}
