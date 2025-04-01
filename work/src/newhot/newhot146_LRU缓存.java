package newhot;

import java.util.HashMap;
import java.util.Map;

public class newhot146_LRU缓存 {

    public static class linkedNode {
        public linkedNode() {
        }
        public linkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
        public int key;
        public int val;
        public linkedNode pre;
        public linkedNode next;
    }

    Integer capacity;
    linkedNode head;
    linkedNode tail;
    Map<Integer, linkedNode> map;

    public newhot146_LRU缓存(int capacity) {
        this.capacity = capacity;
        head = new linkedNode();
        tail = new linkedNode();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        linkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        linkedNode node = map.get(key);
        // 更新
        if (node != null) {
            node.val = value;
            moveToHead(node);
            return;
        }
        // 插入
        linkedNode linkedNode = new linkedNode(key, value);
        map.put(key, linkedNode);
        addToHead(linkedNode);
        if (capacity > 0) {
            capacity--;
        } else {
            int removed = removeTail();
            map.remove(removed);
        }
    }

    public int removeTail() {
        linkedNode node = tail.pre;
        // tail.pre至少是head，不可能为null
        linkedNode pre = node.pre;
        if (pre != null) {
            pre.next = tail;
            tail.pre = pre;
        }
        // 需要返回key，用于删除map中的值
        return node.key;
    }

    public void removeNode(linkedNode node) {
        // 肯定不是head和tail
        node.next.pre = node.pre;
        node.pre.next = node.next;

    }

    public void moveToHead(linkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(linkedNode node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

}
