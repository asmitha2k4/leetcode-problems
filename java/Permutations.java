import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        
        backtrack(nums, path, visited, result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path)); // add a copy of current permutation
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                
                backtrack(nums, path, visited, result);
                
                // backtrack
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
