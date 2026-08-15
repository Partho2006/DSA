// https://leetcode.com/problems/set-mismatch/

import java.util.*;

class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        long n = nums.length;
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }
        long val1 = S - SN; 
        long val2 = S2 - S2N;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2; 
        long y = x - val1;          
        return new int[]{(int) x, (int) y};
    }
}

public class find_the_repeating_and_missing_numbers {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};
        
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);
        System.out.println("The repeating and missing numbers are: {" 
                            + result[0] + ", " + result[1] + "}");
    }
}

// Example 1:
// Input:
//  nums = [3, 5, 4, 1, 1]  
// Output:
//  [1, 2]  
// Explanation:
//  1 appears twice in the array, and 2 is missing from the array. So the output is [1, 2].
