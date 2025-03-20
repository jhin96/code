package leetcode100;

import utils.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * https://leetcode.cn/problems/swap-nodes-in-pairs/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot24_两两交换链表中的节点 {

    public static void main(String[] args) {
        hot24_两两交换链表中的节点 hot24_两两交换链表中的节点 = new hot24_两两交换链表中的节点();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = hot24_两两交换链表中的节点.swapPairs(listNode1);
    }

    /**
     * 借助一个辅助指针记录之前的尾节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (head != null && head.next != null) {
            // 移动当前节点与后节点
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = head;
            // 将上一个结尾与这个节点相连
            cur.next = tmp;
            // 移动指针
            cur = head;
            head = head.next;
        }
        return pre.next;
    }

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，递归的栈空间
     *
     * @param head
     * @return
     */
    public ListNode method1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        // 递归处理下下个节点
        ListNode next = method1(node.next);
        // 处理指针
        head.next = next;
        node.next = head;
        return node;
    }

}
