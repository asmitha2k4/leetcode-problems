import java.util.*;

class DinnerPlates {
    private int capacity;
    private List<Stack<Integer>> stacks;
    private TreeSet<Integer> available;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.available = new TreeSet<>();
    }

    public void push(int val) {
        // Find the leftmost stack with space
        // If TreeSet is empty, it means we need to add a new stack at the end
        if (available.isEmpty()) {
            stacks.add(new Stack<>());
            available.add(stacks.size() - 1);
        }

        int leftmost = available.first();
        stacks.get(leftmost).push(val);

        // If this stack is now full, remove it from the 'available' set
        if (stacks.get(leftmost).size() == capacity) {
            available.remove(leftmost);
        }
    }

    public int pop() {
        // We need the rightmost non-empty stack.
        // If stacks are empty at the end (due to popAtStack), remove them.
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            int lastIdx = stacks.size() - 1;
            stacks.remove(lastIdx);
            available.remove(lastIdx);
        }

        if (stacks.isEmpty()) return -1;

        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        // Check if index is valid and the stack isn't empty
        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }

        int val = stacks.get(index).pop();
        
        // Since we just removed an item, this stack definitely has space now.
        // Add it to the 'available' set so 'push' can find it.
        available.add(index);
        
        return val;
    }
}
