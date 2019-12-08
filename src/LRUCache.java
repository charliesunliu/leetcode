import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }
    private void toFront(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNode(DLinkedNode node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private DLinkedNode popLast(){
        DLinkedNode res = tail.prev;
        removeNode(tail.prev);
        return res;
    }


    private Map<Integer, DLinkedNode> cache;
    private int size;
    private int capacity;
    private DLinkedNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }
        DLinkedNode temp = cache.get(key);
        toFront(temp);

        return temp.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);

            size++;
            if (size > capacity){
                DLinkedNode lastNode = popLast();
                cache.remove(lastNode.key);
            }
        }else {
            node.value = value;
            toFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */