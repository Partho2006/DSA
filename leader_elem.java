import java.util.*;

class Solution {
    public int[] rearrange(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];      
        int maxi = Integer.MIN_VALUE; 
        int c = 0;  
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > maxi) {
                maxi = nums[i]; 
                arr[c] = nums[i]; 
                c++;
            }
        }
        return Arrays.copyOf(arr, c); //-> The return Arrays.copyOf(arr, c); statement creates and returns a new array, taking only the first c valid elements from the temporary arr. It prevents returning an array full of empty or default 0 values that were created during initialization
    }
}

public class leader_elem {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr = {10, 22, 12, 3, 0, 6};
        int[] nums = obj.rearrange(arr);
        System.out.print("Leader elements: ");
        for (int i = nums.length-1; i >= 0; i--) {
            System.out.print(nums[i] + ", ");
        }
    }
}
// Input:
//  arr = [10, 22, 12, 3, 0, 6]  
// Output:
//  22 12 6  
// Explanation:
//  6 is a leader because there are no elements after it.  
// 12 is greater than all the elements to its right (3, 0, 6), and 22 is greater than 12, 3, 0, 6, making them leaders as well.