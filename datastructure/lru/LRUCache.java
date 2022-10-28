package datastructure.lru;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleLinkedList cache;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedList();
        this.capacity = capacity;
    }

    private void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    private void removeKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node x = cache.removeFirst();
        map.remove(x.key);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            removeKey(key);
            addRecently(key, val);
        }

        if (capacity == cache.size()) {
            removeLeastRecently();
        }

        addRecently(key, val);
    }
}
