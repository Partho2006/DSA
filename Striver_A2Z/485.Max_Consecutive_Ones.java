// 485. Max Consecutive Ones
// Given a binary array nums, return the maximum number of consecutive 1's in the array.

// Example 1:
// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;

        for (int n : nums) {
            if (n == 0) {
                count = 0;
            } else {
                count++;
            }

            if (res < count) {
                res = count;
            }
        }
        return res;        
    }
}

// Step 1: Create a variable res and set it to 0. This will store the maximum number of consecutive 1s found.
// Step 2: Create another variable count and set it to 0. This will count the current streak of consecutive 1s.
// Step 3: Loop through each element in the array using for (int n : nums).
// Step 4: For each number, check if it is 0.
// Step 5: If the number is 0, reset count to 0 because the streak of 1s is broken.
// Step 6: If the number is 1, increase count by 1 because the streak continues.
// Step 7: After updating count, compare it with res.
// Step 8: If count is greater than res, update res to the new larger value.
// Step 9: Continue this process until the loop finishes.
// Step 10: Return res, which now contains the maximum number of consecutive 1s in the array.

// Time Complexity: O(n)
// Space Complexity: O(1)