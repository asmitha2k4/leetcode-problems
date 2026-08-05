/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Boundary check
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        // Loop runs until the two pointers meet each other
        while (pA != pB) {
            // If pointer A reaches the end, redirect it to head B; else move forward
            pA = (pA == null) ? headB : pA.next;
            
            // If pointer B reaches the end, redirect it to head A; else move forward
            pB = (pB == null) ? headA : pB.next;
        }

        // Returns either the intersection node reference, or null if they don't intersect
        return pA;
    }
}
