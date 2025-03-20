package leetcode100;

import utils.ListNode;
import utils.ListNodeBuilder;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class hot25_K个一组翻转链表 {

    public static void main(String[] args) {
        hot25_K个一组翻转链表 hot25K个一组翻转链表 = new hot25_K个一组翻转链表();
        ListNode build = ListNodeBuilder.build(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ListNode listNode = hot25K个一组翻转链表.reverseKGroup(build, 3);
    }

    /**
     * 需要一个辅助变量记录答案，一个辅助节点pre记录前置节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 计算节点数
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }

        ListNode help = new ListNode(-1);
        help.next = head;
        // 前置节点
        ListNode pre = help;

        // 需要翻转的次数
        int loop = length / k;
        for (int m = 0; m < loop; m++) {
            // k个翻转
            for (int i = 1; i < k; i++) {
                ListNode next = head.next;
                head.next = next.next;
                // 注意这里不能用head，因为pre每轮都会变
                next.next = pre.next;
                pre.next = next;
            }
            pre = head;
            head = head.next;
        }
        return help.next;
    }

}
