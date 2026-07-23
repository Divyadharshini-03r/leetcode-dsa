import java.util.*;

public class Solution {
    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private static final int LIMIT = 200 * 199 / 2; // max area 200 blocked cells

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(hash(b[0], b[1]));
        }

        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] end, Set<Long> blockedSet) {
        Set<Long> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited.add(hash(start[0], start[1]));

        while (!q.isEmpty() && visited.size() <= LIMIT) {
            int[] curr = q.poll();
            if (curr[0] == end[0] && curr[1] == end[1]) return true;

            for (int[] d : dirs) {
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];

                if (nx < 0 || nx >= 1_000_000 || ny < 0 || ny >= 1_000_000) continue;

                long h = hash(nx, ny);
                if (!blockedSet.contains(h) && visited.add(h)) {
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // if visited more than LIMIT cells, area is not enclosed
        return visited.size() > LIMIT;
    }

    private long hash(int x, int y) {
        return ((long)x << 20) | y; // unique encoding for 1e6 x 1e6 grid
    }

    // Optional test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] blocked1 = {{0,1},{1,0}};
        int[] source1 = {0,0}, target1 = {0,2};
        System.out.println(sol.isEscapePossible(blocked1, source1, target1)); // false

        int[][] blocked2 = {};
        int[] source2 = {0,0}, target2 = {999_999,999_999};
        System.out.println(sol.isEscapePossible(blocked2, source2, target2)); // true
    }
}