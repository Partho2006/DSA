// 31. Next Permutation
// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.

// The replacement must be in place and use only constant extra memory.

// Example 1:
// Input: nums = [1,2,3]
// Output: [1,3,2]

class Solution {
    // Function to find next permutation
    public void nextPermutation(int[] nums) {
        // Set index to -1
        int index = -1;

        // Find the first decreasing element from end
        for (int i = nums.length - 2; i >= 0; i--) {
            // If smaller found
            if (nums[i] < nums[i + 1]) {
                // Store index
                index = i;
                break;
            }
        }

        // If no index found
        if (index == -1) {
            // Reverse the entire array
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Find just larger element
        for (int i = nums.length - 1; i > index; i--) {
            // Swap them
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Reverse part after index
        reverse(nums, index + 1, nums.length - 1);
    }

    // Helper to reverse array
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Helper to swap
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Time Complexity: O(N), we find the breaking point and reverse the subarray in linear time.
// Space Complexity: O(1), constant additional space is used.


// Next Permutation 

// Goal:
// Find the next greater permutation (next bigger arrangement of numbers).
// If not possible, return the smallest permutation (sorted ascending).

// Step 1:
// Start from the right side and find the first position where
// nums[i] < nums[i + 1].

// This is the break point.
// Store its index.

// If no such index is found,
// that means array is in descending order.
// So just reverse the entire array and return.

// Step 2:
// From the right side again, find the first element
// which is greater than nums[index].

// Swap this element with nums[index].

// Step 3:
// Reverse the part of the array after index.
// (From index + 1 to end)