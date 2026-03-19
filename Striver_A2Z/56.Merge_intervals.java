// 56. Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for (int[] i : intervals) {
            if (i[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], i[1]);
            } else {
                newInterval = i;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

// Time complexity: O(nlogn)
// Space complexity: O(n)


// You’re given intervals like:
// [1,3], [2,6], [8,10]

// Some overlap, some don’t.

// Your job:
// 👉 **Merge overlapping ones into a single interval**

// ---

// ## 🔹 How to think (no jargon)

// ### 1. Sort first

// Put intervals in order of starting time:

// ```
// [1,3], [2,6], [8,10]
// ```

// If you don’t sort → you’ll mess up comparisons.

// ---

// ### 2. Start with the first interval

// ```
// current = [1,3]
// ```

// ---

// ### 3. Compare next interval

// Take `[2,6]`

// Check:

// ```
// Does 2 ≤ 3 ?
// ```

// Yes → overlap

// So merge:

// ```
// current = [1,6]
// ```

// ---

// ### 4. Move to next

// Take `[8,10]`

// Check:

// ```
// Does 8 ≤ 6 ?
// ```

// No → no overlap

// So:

// * Save `[1,6]`
// * Start new interval → `[8,10]`

// ---

// ## 🔥 Final Answer

// ```
// [1,6], [8,10]
// ```

// ---

// ## ⚡ One-line logic

// 👉 If next start ≤ current end → merge
// 👉 Else → store current and start new one

// ---

// ## 💡 Real-life analogy

// Think of time slots:

// * Meeting 1: 1–3
// * Meeting 2: 2–6

// They clash → combine → 1–6

// But:

// * Meeting 3: 8–10

// No clash → separate

// ## 🎯 What actually matters (don’t forget this)

// Most interval problems =
// Sort → Compare → Merge