import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    // Stack to keep track of the ancestors for the in-order traversal path
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        // Initialize the stack by pushing all leftmost nodes from the root
        pushAllLeft(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        // The top node of the stack is always the next smallest element
        TreeNode node = stack.pop();
        
        // If this node has a right child, we must process its left-leaning branch
        if (node.right != null) {
            pushAllLeft(node.right);
        }
        
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        // If the stack is not empty, there is a valid next node
        return !stack.isEmpty();
    }

    // Helper method to push a node and all of its sequential left children onto the stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
