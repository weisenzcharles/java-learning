package org.charles.learning.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private int capacity;

    public LRUCache(int capacity) {
//        super(capacity, 0.75f, true);
//        this.capacity = capacity;
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public Object get(Object key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(Object key, Object value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            LinkedNode newNode = new LinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                LinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

//    public V get(Object key) {
//        return super.get(key);
//    }
//
//
//    public V put(K key, V value) {
//        return super.put(key, value);
//    }
//
//
//    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//        return size() > capacity;
//    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put("a", "aa2aaa");
        lruCache.put("b", "aa3aaa");
        lruCache.put("c", "aaataa");
        lruCache.put("d", "aaaaa");
        lruCache.put("e", "aaraaa");
        lruCache.get("d");
        lruCache.put("f", "aaaasa");
        lruCache.get("a");
        lruCache.put("g", "aaaaa");
        lruCache.get("d");
        lruCache.put("h", "aaacaa");
        lruCache.get("d");
        lruCache.put("s", "aaaa4a");
        lruCache.get("b");
        lruCache.put("w", "aaasaa");
        lruCache.get("d");
        lruCache.put("t", "aaataa");
        lruCache.get("a");
        lruCache.put("q", "aaacaa");

        System.out.println(lruCache);
    }

    private void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private LinkedNode removeTail() {
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Object, LinkedNode> cache = new HashMap<>();
    private int size;
    private LinkedNode head, tail;


    class LinkedNode {
        Object key;
        Object value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(Object key, Object value) {
            key = key;
            value = value;
        }
    }


}
