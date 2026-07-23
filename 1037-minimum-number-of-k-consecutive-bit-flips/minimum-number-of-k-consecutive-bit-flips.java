public class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCount = 0; // number of active flips affecting current index

        int[] isFlipped = new int[n]; // mark where flips end

        for (int i = 0; i < n; i++) {
            // Remove the effect of flips that ended at i
            if (i >= k) flipCount -= isFlipped[i - k];

            // If current bit after flips is 0, we need to flip
            if ((nums[i] + flipCount) % 2 == 0) {
                if (i + k > n) return -1; // cannot flip beyond array
                flips++;
                flipCount++;          // apply flip
                isFlipped[i] = 1;    // mark the flip ends at i+k-1
            }
        }

        return flips;
    }

    // Optional test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {0,1,0};
        System.out.println(sol.minKBitFlips(nums1, 1)); // 2

        int[] nums2 = {1,1,0};
        System.out.println(sol.minKBitFlips(nums2, 2)); // -1

        int[] nums3 = {0,0,0,1,0,1,1,0};
        System.out.println(sol.minKBitFlips(nums3, 3)); // 3
    }
}