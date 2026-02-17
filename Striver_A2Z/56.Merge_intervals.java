56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

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

Alright. Let’s break this down properly — line by line — so you actually understand what’s happening.

This is the classic **Merge Intervals** problem.

---

## 🔹 Method Signature

```java
public int[][] merge(int[][] intervals)
```

* Input: `intervals` → 2D array
  Example: `[[1,3],[2,6],[8,10],[15,18]]`
* Output: merged overlapping intervals
  Example: `[[1,6],[8,10],[15,18]]`

---

## 🔹 Step 1: Edge Case

```java
if (intervals.length <= 1) return intervals;
```

If:

* There are **0 intervals** → nothing to merge.
* There is **1 interval** → already merged.

So we directly return.

No extra work needed.

---

## 🔹 Step 2: Sort the Intervals

```java
Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
```

This sorts intervals based on **starting time**.

Why?

Because merging only works correctly if intervals are ordered by start time.

### Example before sorting:

```
[8,10], [1,3], [2,6]
```

### After sorting:

```
[1,3], [2,6], [8,10]
```

Now overlaps become easy to detect.

⚠️ Without sorting, this logic would fail.

---

## 🔹 Step 3: Create Result List

```java
List<int[]> res = new ArrayList<>();
```

We cannot directly modify and return the input array easily because:

* We don’t know final size
* Merging reduces number of intervals

So we store results in a dynamic list first.

---

## 🔹 Step 4: Start with First Interval

```java
int[] newInterval = intervals[0];
res.add(newInterval);
```

* Take the first interval as the current interval to compare.
* Add it to result.

Think of it as:

> "This is my current working interval."

---

## 🔹 Step 5: Traverse All Intervals

```java
for (int[] i : intervals)
```

We now check each interval one by one.

---

## 🔹 Step 6: Check Overlap

```java
if (i[0] <= newInterval[1])
```

Condition means:

Start of current interval ≤ End of previous interval

That means → they overlap.

### Example:

Previous interval:

```
[1,3]
```

Current interval:

```
[2,6]
```

Since:

```
2 <= 3
```

They overlap.

---

## 🔹 Step 7: Merge

```java
newInterval[1] = Math.max(newInterval[1], i[1]);
```

We update the ending time to the bigger one.

Example:

```
[1,3] and [2,6]
```

New merged interval:

```
[1,6]
```

Why?

Because merged interval should cover both completely.

---

## 🔹 Step 8: No Overlap Case

```java
else {
    newInterval = i;
    res.add(newInterval);
}
```

If they don't overlap:

Example:

```
[1,6] and [8,10]
```

Since:

```
8 > 6
```

No overlap.

So:

* Start a new interval
* Add it to result

---

## 🔹 Step 9: Convert List to Array

```java
return res.toArray(new int[res.size()][]);
```

Because function must return `int[][]`, not List.

So we convert the list back to 2D array.

---

# 🔥 Full Dry Run Example

Input:

```
[[1,3],[2,6],[8,10],[15,18]]
```

After sorting:

```
[[1,3],[2,6],[8,10],[15,18]]
```

### Iteration 1:

Current = [1,3]

### Iteration 2:

[2,6] overlaps with [1,3]

Merged → [1,6]

### Iteration 3:

[8,10] does NOT overlap with [1,6]

Add new interval → [8,10]

### Iteration 4:

[15,18] does NOT overlap with [8,10]

Add new interval → [15,18]

Final result:

```
[[1,6],[8,10],[15,18]]
```

---

# ⏱ Time & Space Complexity

### Time Complexity:

* Sorting → **O(n log n)**
* Traversal → **O(n)**

Overall:

```
O(n log n)
```

### Space Complexity:

* Result list → O(n)

---

# 🎯 Core Logic in One Sentence

1. Sort intervals by start time.
2. Compare each interval with the previous one.
3. Merge if overlapping.
4. Otherwise, add as new interval.

---

Since you're learning DSA seriously now, understand this clearly:

👉 Most interval problems = **Sort + Compare with previous**

That pattern repeats in many questions.
