import java.util.*;

class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        backtrack(candidates, target, 0, current, result);
        
        return result;
    }
    
    
    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {
        
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if(target < 0) {
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            
            current.add(candidates[i]);
            
            // i (not i+1) because we can reuse same number
            backtrack(candidates, target - candidates[i], i, current, result);
            
            // backtrack (remove last element)
            current.remove(current.size() - 1);
        }
    }
}
