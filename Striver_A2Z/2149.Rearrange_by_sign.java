// 2149. Rearrange Array Elements by Sign
// You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

// You should return the array of nums such that the array follows the given conditions:

// Every consecutive pair of integers have opposite signs.
// For all integers with the same sign, the order in which they were present in nums is preserved.
// The rearranged array begins with a positive integer.
// Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

// Example 1:
// Input: nums = [3,1,-2,-5,2,-4]
// Output: [3,-2,1,-5,2,-4]
// Explanation:
// The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
// The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
// Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions. 

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 1;
        while(pos < n && neg < n) {
            if(nums[pos] >= 0) pos += 2;
            else if(nums[neg] < 0) neg += 2;
            else {
                int temp = nums[pos];
                nums[pos] = nums[neg];
                nums[neg] = temp;
            }
        }
        return nums;
    }
}

// Step 1:
// Take two pointers:
// pos = 0 (for positive numbers at even index)
// neg = 1 (for negative numbers at odd index)

// Step 2:
// Loop while both pointers are inside the array.

// Step 3:
// For each step:
// If number at pos is positive → move pos by 2.
// If number at neg is negative → move neg by 2.
// Otherwise → swap the numbers at pos and neg.

// Step 4:
// Return the array.



// Time Complexity: O(n)
// Space Complexity: O(1)