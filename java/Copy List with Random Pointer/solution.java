// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a new cloned node for each original node 
        // and link it directly next to the original node.
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Assign random pointers for the cloned nodes.
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original list and the cloned list.
        curr = head;
        Node dummyHead = new Node(0);
        Node cloneCurr = dummyHead;

        while (curr != null) {
            Node nextOriginal = curr.next.next;

            // Extract the clone
            cloneCurr.next = curr.next;
            cloneCurr = cloneCurr.next;

            // Restore the original list
            curr.next = nextOriginal;
            
            curr = nextOriginal;
        }

        return dummyHead.next;
    }
}
