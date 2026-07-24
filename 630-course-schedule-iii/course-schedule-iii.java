import java.util.*;
public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> taken = new PriorityQueue<>(Collections.reverseOrder());
        int totalTime = 0;
        for (int[] course : courses) {
            int duration = course[0], deadline = course[1];
            totalTime += duration;
            taken.offer(duration);
            if (totalTime > deadline) {
                totalTime -= taken.poll();
            }
        }
        return taken.size();
    }
}
