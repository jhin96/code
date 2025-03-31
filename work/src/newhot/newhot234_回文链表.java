package newhot;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class newhot234_回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针+翻转链表
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 奇数/偶数链表不同(奇数slow指向中间节点，偶数slow指向中间偏右节点)，所以翻转后从右边开始比较
        ListNode node = reverseList(slow);
        while (node != null) {
            if (node.val != head.val) {
                return false;
            }
            head = head.next;
            node = node.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public boolean method1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
