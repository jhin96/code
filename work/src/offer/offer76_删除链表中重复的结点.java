package offer;

import utils.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5
 *
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=23450&sourceUrl=
 *
 */
public class offer76_删除链表中重复的结点 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (pHead != null) {
            // 看当前节点是否不重复or下一节点是不是空，满足任一条件就能保留
            if (pHead.next == null || pHead.val != pHead.next.val) {
                cur.next = pHead;
                cur = cur.next;
            }
            // 相当于处理完这个节点了，指向下一节点
            while (pHead.next != null && pHead.val == pHead.next.val) {
                pHead = pHead.next;
            }
            pHead = pHead.next;
        }
        // 处理尾节点
        cur.next = null;
        return pre.next;
    }

    /**
     * 复杂方法
     *
     * @param pHead
     * @return
     */
    public ListNode method1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode cur = pHead;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        while (cur != null) {
            if (list.contains(cur.val)) {
                set.add(cur.val);
            }
            list.add(cur.val);
            cur = cur.next;
        }
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        while (pHead != null) {
            if (!set.contains(pHead.val)) {
                pre.next = new ListNode(pHead.val);
                pre = pre.next;
                pHead = pHead.next;
            } else {
                pHead = pHead.next;
            }
        }
        return res.next;
    }

}
