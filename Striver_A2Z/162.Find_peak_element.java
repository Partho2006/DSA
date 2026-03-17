// 162. Find Peak Element

// A peak element is an element that is strictly greater than its neighbors.
// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
// You must write an algorithm that runs in O(log n) time.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.

class Solution {
    // Function to find a peak element using binary search
    public int findPeakElement(int[] nums) {
        // Set left and right bounds
        int low = 0, high = nums.length - 1;

        // Binary search loop
        while (low < high) {
            // Find mid point
            int mid = (low + high) / 2;

            // If mid element is greater than next
            if (nums[mid] > nums[mid + 1]) {
                // Move to left half
                high = mid;
            } else {
                // Move to right half
                low = mid + 1;
            }
        }
        // Return peak index
        return low;
    }
}

// Time complexity: O(logn) 
// Space complexity: O(1)

// Initialize the search space to the full range of the array.
// Find the middle index of the current search range.
// Check if the middle element is greater than its right neighbor.
// If yes, then a peak must exist in the left half (including mid), so shrink the right bound.
// Otherwise, the peak must lie in the right half (excluding mid), so shift the left bound.
// Continue until the search space converges to a single element.
// This final position is the index of a peak element.