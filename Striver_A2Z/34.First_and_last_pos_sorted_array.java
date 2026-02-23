// 34. Find First and Last Position of Element in Sorted Array
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] N, int T) {
        int Tleft = find(T, N, 0);
        if (Tleft == N.length || N[Tleft] != T) return new int[] {-1, -1};
        return new int[] {Tleft, find(T+1, N, Tleft) - 1};
    }
    public int find(int target, int[] arr, int left) {
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}

// Time complexity: O(logn)
// Space complexity: O(1)


// ### Main idea

// Instead of writing two different searches, it uses one helper function:

// `find(target)` → returns the **first index where value ≥ target**
// (this is called *lower bound*).

// ---

// ### Step 1: Find first occurrence

// ```java
// int Tleft = find(T, N, 0);
// ```

// This gives the first index where number is ≥ T.

// If:

// * index == array length
// * or value at that index ≠ T

// → target doesn’t exist → return `[-1, -1]`.

// ---

// ### Step 2: Find last occurrence

// ```java
// find(T + 1, N, Tleft) - 1
// ```

// Why `T + 1`?

// Because:

// * First index where value ≥ (T + 1)
// * That position is just **after the last T**
// * So subtract 1

// Smart trick.

// ---

// ### Helper function (Binary Search)

// ```java
// while (left <= right) {
//     int mid = (left + right) >> 1;
//     if (arr[mid] < target)
//         left = mid + 1;
//     else
//         right = mid - 1;
// }
// return left;
// ```

// It keeps shrinking the range.

// When loop ends, `left` is the first position where value ≥ target.
