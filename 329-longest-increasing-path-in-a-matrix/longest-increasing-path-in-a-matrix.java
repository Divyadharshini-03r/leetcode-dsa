class Solution {
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private int m, n;
    private int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j));
            }
        }
        return maxLen;
    }
    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];
        int max = 1; 
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, 1 + dfs(matrix, x, y));
            }
        }
        memo[i][j] = max; 
        return max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix1 = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(sol.longestIncreasingPath(matrix1));
        int[][] matrix2 = {{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(sol.longestIncreasingPath(matrix2)); 
        int[][] matrix3 = {{1}};
        System.out.println(sol.longestIncreasingPath(matrix3)); 
    }
}