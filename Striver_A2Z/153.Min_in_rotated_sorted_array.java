// 153. Find Minimum in Rotated Sorted Array

// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given the sorted rotated array nums of unique elements, return the minimum element of this array.

// You must write an algorithm that runs in O(log n) time.

// Example 1:
// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

class Solution {
    // Function to find the minimum element using binary search
    public int findMin(int[] nums) {

        // Initialize low and high pointers
        int low = 0, high = nums.length - 1;

        // Binary search loop
        while (low < high) {

            // Calculate mid index
            int mid = low + (high - low) / 2;

            // Check which half to discard
            if (nums[mid] > nums[high]) {

                // Minimum lies in right half
                low = mid + 1;

            } else {

                // Minimum lies in left half (including mid)
                high = mid;
            }
        }

        // Return the minimum element
        return nums[low];
    }
}


// Time complexity: O(logn) 
// Space complexity: O(1)

// In a rotated sorted array, the smallest element represents the point of rotation. It is the only element that is smaller than its previous element. Since the array is sorted in two segments, we can use binary search to efficiently find this pivot point. By comparing the middle element with the rightmost element in the current search space, we can determine which half of the array contains the minimum element.
// Initialize pointers to the start and end of the array.
// While start is less than end, calculate the middle index.
// If the middle element is greater than the rightmost element, move the start to mid + 1.
// Else, move the end to mid (because mid can be the minimum).
// When the loop ends, start will point to the minimum element.