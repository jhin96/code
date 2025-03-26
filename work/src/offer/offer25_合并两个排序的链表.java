package offer;

import utils.ListNode;

/**
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 要求：空间复杂度：O(1)，时间复杂度：O(n)
 *
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=23267&sourceUrl=
 *
 */
public class offer25_合并两个排序的链表 {

    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return pHead1 == null ? pHead2 : pHead1;
        }
        if (pHead1.val < pHead2.val) {
            pHead1.next = Merge(pHead1.next, pHead2);
            return pHead1;
        } else {
            pHead2.next = Merge(pHead1, pHead2.next);
            return pHead2;
        }
    }

    public ListNode method1 (ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return pHead1 == null ? pHead2 : pHead1;
        }
        ListNode node = new ListNode(-1);
        ListNode res = node;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                node.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                node.next = pHead2;
                pHead2 = pHead2.next;
            }
            node = node.next;
        }
        node.next = pHead1 == null ? pHead2 : pHead1;
        return res.next;
    }

}
