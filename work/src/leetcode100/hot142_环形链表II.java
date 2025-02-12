package leetcode100;


import utils.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 *
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot142_环形链表II {

    /**
     * 快慢指针找到入口，找到相遇节点后，头节点与相遇节点再次相遇就是入口
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 记录相遇的节点
        ListNode tmp = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
            if (head == fast) {
                while (tmp != fast) {
                    tmp = tmp.next;
                    fast = fast.next;
                }
                return tmp;
            }
        }
        return null;
    }

}