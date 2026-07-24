class Solution {
    public int numDecodings(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        long dp0 = 1; 
        long dp1 = ways1(s.charAt(0)); 
        for (int i = 1; i < n; i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i - 1);
            long single = ways1(cur) * dp1 % MOD;
            long pair = ways2(prev, cur) * dp0 % MOD;
            long dp2 = (single + pair) % MOD;
            dp0 = dp1;
            dp1 = dp2;
        }
        return (int) dp1;
    }
    private int ways1(char c) {
        if (c == '*') return 9;
        return c == '0' ? 0 : 1;
    }
    private int ways2(char c1, char c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        } else if (c1 == '*') {
            if (c2 >= '0' && c2 <= '6') return 2; 
            else return 1; 
        } else if (c2 == '*') {
            if (c1 == '1') return 9;
            if (c1 == '2') return 6;
            return 0;
        } else {
            int num = (c1 - '0') * 10 + (c2 - '0');
            return (num >= 10 && num <= 26) ? 1 : 0;
        }
    }
}
