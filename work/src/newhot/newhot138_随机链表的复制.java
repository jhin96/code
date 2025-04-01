package newhot;

import utils.Node;

import java.util.HashMap;
import java.util.Map;

public class newhot138_随机链表的复制 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node tmp = head;
        while (tmp != null) {
            map.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }
        Node cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

}