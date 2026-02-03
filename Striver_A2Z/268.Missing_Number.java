// 268. Missing Numbers
// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

// Example 1:
// Input: nums = [3,0,1]
// Output: 2
// Explanation:
// n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n += i - nums[i];
        }
        return n;
    }
}

// Step 1: Store the length of the array in a variable n. This represents the maximum number that should be present.

// Step 2: Start a loop from index 0 to nums.length - 1.

// Step 3: In each iteration, update n using the expression n = n + i - nums[i].

// Step 4: Here, i represents the expected number, and nums[i] represents the actual number in the array.

// Step 5: The difference between expected and actual values keeps adjusting n.

// Step 6: If no number were missing, all additions and subtractions would cancel out.

// Step 7: Because one number is missing, the final value of n becomes that missing number.

// Step 8: After the loop ends, return n as the missing number.

// Time Complexity: O(n)
// Space Complexity: O(1)