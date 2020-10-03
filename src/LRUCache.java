import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LRUCache {


    class node{
        int key;
        int value;
        node prev;
        node next;
    }

    private void addNode(node n){
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;

    }

    private void removeNode(node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void moveToHead(int num, int value){
        node n = cache.get(num);
        n.value = value;
        removeNode(n);
        addNode(n);
    }

    private void removeFromTail(){
        cache.remove(tail.prev.key);
        removeNode(tail.prev);
    }

    private Map<Integer, node> cache;
    private int capacity;
    private int size;
    private node head;
    private node tail;


    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new node();
        this.tail = new node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            moveToHead(key, cache.get(key).value);
            return cache.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0){
            return;
        }

        if (cache.containsKey(key)){
            moveToHead(key, value);
            return;
        }
        if (size == capacity){
            removeFromTail();
            size--;
        }
        node newNode = new node();
        cache.put(key, newNode);
        newNode.key = key; newNode.value = value;
        addNode(newNode);
        size++;
    }



//    class DLinkedNode {
//        int key;
//        int value;
//        DLinkedNode prev;
//        DLinkedNode next;
//    }
//    private void toFront(DLinkedNode node){
//        removeNode(node);
//        addNode(node);
//    }
//    private void removeNode(DLinkedNode node){
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//    }
//    private void addNode(DLinkedNode node){
//        node.next = head.next;
//        head.next.prev = node;
//        node.prev = head;
//        head.next = node;
//    }
//
//    private DLinkedNode popLast(){
//        DLinkedNode res = tail.prev;
//        removeNode(tail.prev);
//        return res;
//    }
//
//
//    private Map<Integer, DLinkedNode> cache;
//    private int size;
//    private int capacity;
//    private DLinkedNode head, tail;
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        this.size = 0;
//        this.head = new DLinkedNode();
//        this.tail = new DLinkedNode();
//        this.cache = new HashMap<>();
//    }
//
//    public int get(int key) {
//        if (!cache.containsKey(key)){
//            return -1;
//        }
//        DLinkedNode temp = cache.get(key);
//        toFront(temp);
//
//        return temp.value;
//    }
//
//    public void put(int key, int value) {
//        DLinkedNode node = cache.get(key);
//        if (node == null){
//            DLinkedNode newNode = new DLinkedNode();
//            newNode.key = key;
//            newNode.value = value;
//            cache.put(key, newNode);
//            addNode(newNode);
//
//            size++;
//            if (size > capacity){
//                DLinkedNode lastNode = popLast();
//                cache.remove(lastNode.key);
//            }
//        }else {
//            node.value = value;
//            toFront(node);
//        }
//    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */