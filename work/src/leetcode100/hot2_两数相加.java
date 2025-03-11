package leetcode100;

import utils.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * https://leetcode.cn/problems/add-two-numbers/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot2_两数相加 {

    public static void main(String[] args) {
        hot2_两数相加 hot2_两数相加 = new hot2_两数相加();
        ListNode l1 = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        ListNode listNode = hot2_两数相加.addTwoNumbers(l1, l2);
    }

    /**
     * 顺序计算，用变量存储进位
     * 时间复杂度：O(max(m, n))
     * 空间复杂度：若不考虑结果返回则是O(1)，否则是O(max(m, n))
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // 记录结果
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        // 进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int number1 = l1 == null ? 0 : l1.val;
            int number2 = l2 == null ? 0 : l2.val;
            int sum = (number1 + number2 + carry) % 10;
            carry = (number1 + number2 + carry) / 10;
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            tmp.next = new ListNode(carry);
        }
        return res.next;
    }

}
