package newhot;

import utils.ListNode;

public class newhot23_合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    public ListNode helper (ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        return mergeTwoLists(helper(lists, start, mid), helper(lists, mid + 1, end));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null | list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

}