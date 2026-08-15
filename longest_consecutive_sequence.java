// https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array
import java.util.*;

class Solution {
    public int sequence(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; 
        Arrays.sort(nums); 
        int lastSmaller = Integer.MIN_VALUE; 
        int cnt = 0; 
        int longest = 1; 
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmaller) {
                cnt += 1; 
                lastSmaller = nums[i]; 
            } 
            else if (nums[i] != lastSmaller) {
                cnt = 1; 
                lastSmaller = nums[i]; 
            }
            longest = Math.max(longest, cnt); 
        }
        return longest;
    }
}

public class longest_consecutive_sequence {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr = {100, 4, 200, 1, 3, 2};
        int nums = obj.sequence(arr);
        System.out.print("longest consecutive sequence: " + nums);
    }
}
// Input:
//  nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]  
// Output:
//  9  
// Explanation:
//  The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8], which has a length of 9.