import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;
        
        // Step 1: initialize the heap
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }
        while (pq.size() == nums.size()) {
            int[] curr = pq.poll();
            int min = curr[0];
            if (max - min < end - start || (max - min == end - start && min < start)) {
                start = min;
                end = max;
            }
            
            int row = curr[1];
            int col = curr[2];
            if (col + 1 < nums.get(row).size()) {
                int nextVal = nums.get(row).get(col + 1);
                pq.offer(new int[]{nextVal, row, col + 1});
                max = Math.max(max, nextVal);
            } else {
                break; 
            }
        }
        
        return new int[]{start, end};
    }
}
