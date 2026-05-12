public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLen = 0;

        int freq[] = new int[256];

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            freq[ch]++;

            while (freq[ch] > 1) {

                freq[s.charAt(left)]--;

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        LongestSubstring obj = new LongestSubstring();

        String s = "abcabcbb";

        int result = obj.lengthOfLongestSubstring(s);

        System.out.println(result);
    }
}