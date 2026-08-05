import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    // Node class for Doubly Linked List
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head and tail nodes to avoid null checks
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        remove(node);
        insertAtHead(node); // Move to head as it is most recently used
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // Update value
            remove(node);
            insertAtHead(node);
        } else {
            if (map.size() == capacity) {
                // Remove least recently used item (from tail)
                Node lru = tail.prev;
                map.remove(lru.key);
                remove(lru);
            }
            
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }
    
    // Helper to remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Helper to insert a node at the front (right after dummy head)
    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
