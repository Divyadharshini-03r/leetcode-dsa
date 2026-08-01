import java.util.*;
public class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] stickerCount = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCount[i][c - 'a']++;
            }
        }
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);
        return dfs(memo, stickerCount, target);
    }
    private int dfs(Map<String, Integer> memo, int[][] stickerCount, String target) {
        if (memo.containsKey(target)) return memo.get(target);
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int[] sticker : stickerCount) {
            if (sticker[target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                int remain = targetCount[i] - sticker[i];
                for (int j = 0; j < Math.max(0, remain); j++) {
                    sb.append((char)('a' + i));
                }
            }
            String newTarget = sb.toString();
            int tmp = dfs(memo, stickerCount, newTarget);

            if (tmp != -1) ans = Math.min(ans, 1 + tmp);
        }
        memo.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return memo.get(target);
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        String[] stickers1 = {"with","example","science"};
        String target1 = "thehat";
        System.out.println(obj.minStickers(stickers1, target1)); 
        String[] stickers2 = {"notice","possible"};
        String target2 = "basicbasic";
        System.out.println(obj.minStickers(stickers2, target2)); 
    }
}