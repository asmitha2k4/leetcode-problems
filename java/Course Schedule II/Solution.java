import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Initialize graph representation structures
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        
        // Step 2: Build the adjacency dependency maps
        // [course, pre] means: pre -> course
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        // Step 3: Enqueue all starting courses with 0 incoming prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Array to store the topological ordering sequence
        int[] order = new int[numCourses];
        int index = 0;
        
        // Step 4: Process the dependency graph via BFS stream loop
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            order[index++] = currentCourse; // Record the sequence path
            
            // Decouple dependencies for immediate child courses
            for (int nextCourse : adj.get(currentCourse)) {
                inDegree[nextCourse]--;
                
                // If a child course's dependencies hit zero, it's clear to take
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // If index != numCourses, a circular dependency cycle blocked fulfillment
        if (index != numCourses) {
            return new int[0];
        }
        
        return order;
    }
}
