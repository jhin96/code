package leetcode100;

import utils.ListNode;
import utils.ListNodeBuilder;

import java.util.List;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 题目数据保证整个链式结构中不存在环。
 *
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot160 {

    public static void main(String[] args) {
        ListNode listNode1 = ListNodeBuilder.build(new int[]{3, 2, 1});
        ListNode listNode2 = ListNodeBuilder.build(new int[]{3, 2, 1});
        ListNode intersectionNode = getIntersectionNode(listNode1, listNode2);
        List list = ListNodeBuilder.node2List(intersectionNode);
        System.out.println(list);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // 获取链表长度
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (tmpA != null) {
            tmpA = tmpA.next;
            lengthA++;
        }
        while (tmpB != null) {
            tmpB = tmpB.next;
            lengthB++;
        }

        //长的链表指针先移动
        int step = lengthA > lengthB ? lengthA - lengthB : lengthB - lengthA;
        if (lengthA > lengthB) {
            while (headA != null && step > 0) {
                headA = headA.next;
                step--;
            }
        } else {
            while (headB != null && step > 0) {
                headB = headB.next;
                step--;
            }
        }

        while (headA != headB && headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }

        // 不用考虑null是因为若没有交点，最后headA和headB都是null
        return headA;
    }

    /**
     * 思想：通过遍历两次消除长度差
     * 相当于A和B都走了长度之和的路，来到了同一起跑线
     * 时间复杂度O(m+n) 长度为m、n
     * 空间复杂度O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode method1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != tmpB) {
            tmpA = tmpA == null ? headB : tmpA.next;
            tmpB = tmpB == null ? headA : tmpB.next;
        }
        // 没交点时，tmpA = tmpB = null
        return tmpA;
    }

}