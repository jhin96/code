package offer;

import utils.ListNode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 *
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=23278&sourceUrl=
 *
 */
public class offer6_从尾到头打印链表 {

    /**
     * 递归，类似与树的递归遍历
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        dfs(listNode, res);
        return res;
    }

    public void dfs(ListNode listNode, ArrayList<Integer> res) {
        if (listNode == null) {
            return;
        }
        dfs(listNode.next, res);
        res.add(listNode.val);
    }

    /**
     * 每次添加到第一个位置
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> method1(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

    /**
     * 借助一个栈
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> method2(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * 反转链表
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> method3(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ListNode pre = new ListNode(-1);
        while (listNode != null) {
            ListNode next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        // 之前-1节点不能算
        while (pre.next != null) {
            res.add(pre.val);
            pre = pre.next;
        }
        return res;
    }

}
