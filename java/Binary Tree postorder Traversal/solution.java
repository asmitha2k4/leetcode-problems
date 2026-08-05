import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            
            // Insert at the front to reverse the traversal order
            result.addFirst(curr.val);

            // Push Left child first so Right child is popped and processed next
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        return result;
    }
}
