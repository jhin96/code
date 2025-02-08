package leetcode100;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 *
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 *
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * https://leetcode.cn/problems/lru-cache/description/?envType=problem-list-v2&envId=2cktkvj
 *
 */
public class hot146 {

    /**
     * 双向链表用于处理LRU缓存
     */
    public static class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode() {

        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    int capacity;

    // 初始化头、尾节点
    LinkedNode head, tail;

    // 缓存map
    Map<Integer, LinkedNode> LruCache;

    public hot146(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
        LruCache = new HashMap<>();
    }

    public int get(int key) {
        LinkedNode node = LruCache.get(key);
        if(node == null) {
            return -1;
        }
        moveToToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode update = LruCache.get(key);
        // 更新
        if (update != null) {
            update.value = value;
            moveToToHead(update);
        } else {
            // 添加
            if (capacity > 0) {
                capacity--;
            } else {
                // 没有容量了，capacity = 0
                LinkedNode removeNode = removeTail();
                LruCache.remove(removeNode.key);
            }
            LinkedNode node = new LinkedNode(key, value);
            addToHead(node);
            LruCache.put(node.key, node);
        }
    }

    /**
     * 添加至头节点
     *
     * @param node
     */
    public void addToHead(LinkedNode node) {
        head.next.pre = node;
        node.pre = head;
        node.next = head.next;
        head.next = node;
    }

    /**
     * 移动到头节点
     *
     * @param node
     */
    public void moveToToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public LinkedNode removeTail() {
        LinkedNode preNode = tail.pre;
        if(preNode.pre == null) {
            return null;
        }
        preNode.pre.next = tail;
        tail.pre = preNode.pre;
        return preNode;
    }

    public void removeNode(LinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

}
