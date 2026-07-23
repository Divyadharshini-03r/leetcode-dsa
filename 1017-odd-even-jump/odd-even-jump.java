import java.util.*;

public class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int[] oddNext = makeNext(arr, true);   
        int[] evenNext = makeNext(arr, false); 

        boolean[] oddReach = new boolean[n];
        boolean[] evenReach = new boolean[n];
        oddReach[n-1] = evenReach[n-1] = true;

        for (int i = n - 2; i >= 0; i--) {
            if (oddNext[i] != -1) oddReach[i] = evenReach[oddNext[i]];
            if (evenNext[i] != -1) evenReach[i] = oddReach[evenNext[i]];
        }

        int count = 0;
        for (boolean b : oddReach) if (b) count++;
        return count;
    }

    private int[] makeNext(int[] arr, boolean odd) {
        int n = arr.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        if (odd) {
            Arrays.sort(idx, (a,b) -> arr[a] != arr[b] ? arr[a]-arr[b] : a-b);
        } else {
            Arrays.sort(idx, (a,b) -> arr[a] != arr[b] ? arr[b]-arr[a] : a-b);
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : idx) {
            while (!stack.isEmpty() && i > stack.peek()) {
                res[stack.pop()] = i;
            }
            stack.push(i);
        }
        return res;
    }
}