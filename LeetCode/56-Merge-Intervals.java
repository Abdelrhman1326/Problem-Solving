class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? 
            Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
    
        int steps_backward = 0;
        int count_intervals = 1;

        for (int i = 0; i < intervals.length - 1; i++) {
            int curr = i - steps_backward;

            if (intervals[curr][1] >= intervals[i + 1][0]) {
                intervals[curr][1] = Math.max(intervals[curr][1], intervals[i + 1][1]);
                steps_backward += 1;
            } else {
                intervals[curr + 1][0] = intervals[i + 1][0];
                intervals[curr + 1][1] = intervals[i + 1][1];
                count_intervals++;
            }
        }

        return Arrays.copyOf(intervals, count_intervals);
    }
}