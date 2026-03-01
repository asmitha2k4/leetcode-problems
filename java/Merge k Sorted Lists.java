import java.util.*;

class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        
        // Add first node of each list
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while(!pq.isEmpty()) {
            
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;
            
            if(node.next != null) {
                pq.add(node.next);
            }
        }
        
        return dummy.next;
    }
}
