import java.util.*;
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]}); 
            heights.add(new int[]{b[1], b[2]});  
        }
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        int prevHeight = 0;
        for (int[] h : heights) {
            if (h[1] < 0) { 
                pq.offer(-h[1]);
            } else { 
                pq.remove(h[1]);
            }
            int currHeight = pq.peek();
            if (currHeight != prevHeight) {
                result.add(Arrays.asList(h[0], currHeight));
                prevHeight = currHeight;
            }
        }
        return result;
    }
}