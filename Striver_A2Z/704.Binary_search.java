// 704. Binary Search
// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4

class Solution {
    public int search(int[] nums, int target) {
        int left = 0; // initialize left pointer to 0
        int right = nums.length - 1; // initialize right pointer to the last index of the array
        
        while (left <= right) { // continue the loop till left pointer is less than or equal to right pointer
            int mid = left + (right - left) / 2; // calculate the middle index of the array
            
            if (nums[mid] == target) { // check if the middle element is equal to target
                return mid; // return the middle index
            } else if (nums[mid] < target) { // check if the middle element is less than target
                left = mid + 1; // move the left pointer to the right of middle element
            } else { // if the middle element is greater than target
                right = mid - 1; // move the right pointer to the left of middle element
            }
        }
        
        return -1; // target not found in the array
    }
}

// Time complexity: O(logn) - Since binary search reduces the search space by half at each step, the maximum number of iterations required to find the target is log base 2 of n, where n is the size of the array. Therefore, the time complexity of binary search is O(logn).
// Space complexity: O(1) 


// Initialize left and right pointers to the beginning and end of the array, respectively.

// While the left pointer is less than or equal to the right pointer:

// a. Calculate the middle index as the average of the left and right pointers.
// b. If the middle element is equal to the target, return the index of the middle element.
// c. If the middle element is less than the target, update the left pointer to mid + 1.
// d. If the middle element is greater than the target, update the right pointer to mid - 1.

// If the target is not found, return -1.