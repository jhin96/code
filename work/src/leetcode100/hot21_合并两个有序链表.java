package leetcode100;

import utils.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot21_合并两个有序链表 {

    /**
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode node = new ListNode(-1);
        ListNode res = node;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        node.next = list1 == null ? list2 : list1;
        return res.next;
    }

    public ListNode method1(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val < list2.val) {
            list1.next = method1(list1.next, list2);
            return list1;
        } else {
            list2.next = method1(list1, list2.next);
            return list2;
        }
    }

}
