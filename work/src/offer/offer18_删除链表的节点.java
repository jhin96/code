package offer;

import utils.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 *
 * https://www.nowcoder.com/practice/f9f78ca89ad643c99701a7142bd59f5d?tpId=13&tqId=2273171&sourceUrl=
 *
 */
public class offer18_删除链表的节点 {

    public ListNode deleteNode (ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        pre.next = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                break;
            }
            pre = pre.next;
        }
        return cur.next;
    }

}
