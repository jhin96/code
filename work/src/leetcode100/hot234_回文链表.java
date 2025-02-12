package leetcode100;

import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.Stack;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表；如果是，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/palindrome-linked-list/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot234_回文链表 {

    public static void main(String[] args) {
        ListNode build = ListNodeBuilder.build(1, 2, 3, 3, 2, 1);
        System.out.println(method1(build));
    }

    /**
     * 思路：
     * 不同元素进栈，相同元素出栈不行（121这种不好处理，需要先判断是否为奇数）
     * 还可以进list里用双指针
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i < length / 2; i++){
            stack.push(head.val);
            head = head.next;
        }
        if (length % 2 != 0) {
            head = head.next;
        }
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    /**
     * 快慢指针 + 反转链表
     * 时间复杂度O(n)
     * 空间复杂度O(1)，未用到额外空间
     *
     * @param head
     * @return
     */
    public static boolean method1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针找到中点
        ListNode fast = new ListNode(-1);
        ListNode slow = fast;
        fast.next = head;
        // slow会在中间或者中间偏右那个节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversal = reversal(slow);
        while (head != null) {
            if (reversal.val != head.val) {
                return false;
            }
            reversal = reversal.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reversal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

}
