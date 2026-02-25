// 33. Search in Rotated Sorted Array

// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

// Time complexity: O(logn) 
// Space complexity: O(1) 


// This problem is just **binary search + rotation logic**.

// Array was sorted.
// Then it was rotated at some pivot.

// # 🔥 Core Idea

// In a rotated sorted array:

// 👉 At least ONE half (left or right) is always sorted.

// So each step:

// 1. Find mid.
// 2. Check which half is sorted.
// 3. Decide if target lies inside that half.
// 4. Discard the other half.

// That’s it.

// ---

// # 🧠 Step-by-Step Logic

// ### 1️⃣ Initialize

// ```
// low = 0
// high = n - 1
// ```

// ---

// ### 2️⃣ Binary Search Loop

// ```
// while (low <= high)
// ```

// ---

// ### 3️⃣ Find Mid

// ```
// mid = (low + high) / 2
// ```

// If:

// ```
// nums[mid] == target
// ```

// Return mid.

// ---

// ## 🔍 Case 1: Left Half is Sorted

// If:

// ```
// nums[low] <= nums[mid]
// ```

// Left side is sorted.

// Now check:

// If:

// ```
// nums[low] <= target < nums[mid]
// ```

// Target lies in left half → move left:

// ```
// high = mid - 1
// ```

// Else:

// ```
// low = mid + 1
// ```

// ---

// ## 🔍 Case 2: Right Half is Sorted

// Else → right side is sorted.

// Check:

// If:

// ```
// nums[mid] < target <= nums[high]
// ```

// Target lies in right half → move right:

// ```
// low = mid + 1
// ```

// Else:

// ```
// high = mid - 1
// ```

// ---

// # 🔎 Example

// Input:

// ```
// nums = [4,5,6,7,0,1,2]
// target = 0
// ```

// Step 1:
// mid = 7
// Left half sorted (4–7)
// Target not in that range → move right

// Step 2:
// Now searching `[0,1,2]`
// mid = 1
// Left sorted
// Target in range → move left

// Found at index 4.

// ---

// # ⏱ Complexity

// Time → **O(log n)**
// Space → **O(1)**

// ---

// # 🎯 Why It Works

// Because rotation only breaks array at ONE pivot.

// So:

// * One side remains fully sorted.
// * That gives enough information to discard half each time.