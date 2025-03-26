package offer;

import utils.ListNode;

/**
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 *
 * https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=13&tqId=1377477&sourceUrl=
 *
 */
public class offer22_链表中倒数最后k个结点 {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }
        ListNode tmp = pHead;
        while (tmp != null && k > 0) {
            tmp = tmp.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (tmp != null) {
            pHead = pHead.next;
            tmp = tmp.next;
        }
        return pHead;
    }

}
