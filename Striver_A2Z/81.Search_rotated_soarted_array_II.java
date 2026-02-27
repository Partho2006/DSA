// 81. Search in Rotated Sorted Array II

// There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

// Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

// Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

// You must decrease the overall operation steps as much as possible.

// Example 1:
// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true

class Solution {
    public boolean search(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) return true;

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= k && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}

// Time Complexity: O(logN) 
// Space Complexity: O(1)

// Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the first index, and high will point to the last index.
// Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula: mid = (low+high) // 2 ( ‘//’ refers to integer division)
// Check if arr[mid] = target: If it is, return True.
// Check if arr[low] = arr[mid] = arr[high]: If this condition is satisfied, we will just increment the low pointer and decrement the high pointer by one step. We will not perform the later steps until this condition is no longer satisfied. So, we will continue to the next iteration from this step.
// Identify the sorted half, check where the target is located, and then eliminate one half accordingly:
// If arr[low] <= arr[mid]: This condition ensures that the left part is sorted.
// If arr[low] <= target && target <= arr[mid]: It signifies that the target is in this sorted half. So, we will eliminate the right half (high = mid-1).
// Otherwise, the target does not exist in the sorted half. So, we will eliminate this left half by doing low = mid+1.
// Otherwise, if the right half is sorted:
// If arr[mid] <= target && target <= arr[high]: It signifies that the target is in this sorted right half. So, we will eliminate the left half (low = mid+1).
// Otherwise, the target does not exist in this sorted half. So, we will eliminate this right half by doing high = mid-1.
// Once, the ‘mid’ points to the target, we will return True.
// This process will be inside a loop and the loop will continue until low crosses high. If no element is found, we will return False.