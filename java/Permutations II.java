import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
        boolean[] visited = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        
        backtrack(nums, path, visited, result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // skip if already used
            if (visited[i]) continue;
            
            // skip duplicates: only use the first unused duplicate
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            
            visited[i] = true;
            path.add(nums[i]);
            
            backtrack(nums, path, visited, result);
            
            // backtrack
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
