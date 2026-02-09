// 53. Maximum Subarray
// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Example 1:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return maxSum;
    }
}

// Kadane’s Algorithm 
// Step 1
// Take two variables:
// maxSum = very small value
// currentSum = 0

// Step 2
// Go through the array one by one.

// For each element:
// Add the element to currentSum.
// If currentSum is greater than maxSum, update maxSum.
// If currentSum becomes negative, make it 0.

// Step 3
// After completing the loop, return maxSum.