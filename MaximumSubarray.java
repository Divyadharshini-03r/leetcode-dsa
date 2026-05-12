public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {

            currentSum += num;

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        MaximumSubarray obj = new MaximumSubarray();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Maximum Subarray Sum: " + obj.maxSubArray(nums));
    }
}