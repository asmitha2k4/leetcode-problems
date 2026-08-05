public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Phase 1: Determine if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // If no cycle is found, return null immediately
        if (!hasCycle) {
            return null;
        }

        // Phase 2: Locate the starting node of the cycle
        // Reset one pointer back to the head of the list
        slow = head;
        
        // Move both pointers at the exact same speed (1 step at a time)
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // The point where they collide is the start of the cycle
        return slow;
    }
}
