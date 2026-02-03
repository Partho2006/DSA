// 136. Single Number
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}

// Step 1: Create a variable result and set it to 0. This will store the XOR of all numbers.
// Step 2: Start a loop from index 0 to nums.length - 1.
// Step 3: In each iteration, update result using
// result = result ^ nums[i].
// Step 4: The XOR (^) operator has two important properties:
//     -A number XOR itself = 0
//     -A number XOR 0 = the number itself
// Step 5: Since every number except one appears twice, pairs will cancel out:
// a ^ a = 0
// Step 6: After all pairs cancel, only the number that appears once remains in result.
// Step 7: After the loop ends, return result.

// Time Complexity: O(n)
// Space Complexity: O(1)