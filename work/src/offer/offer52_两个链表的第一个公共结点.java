package offer;

import utils.ListNode;

/**
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=23257&sourceUrl=
 *
 */
public class offer52_两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode tmp1 = pHead1;
        ListNode tmp2 = pHead2;
        while (pHead1 != pHead2) {
            // 需要都走到null，不然找不到交点
            pHead1 = pHead1 == null ? tmp2 : pHead1.next;
            pHead2 = pHead2 == null ? tmp1 : pHead2.next;
        }
        // 没有公共节点时都为null
        return pHead1;
    }

}
