// https://leetcode.com/problems/maximum-product-subarray/
// https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array

import java.util.*;

// class Solution {
//     public int maxProduct(int[] nums) {
//         int maxi=nums[0];
//         int n=nums.length;
//         for(int i=0; i<n; i++) {
//             int mul=1;
//             for(int j=i; j<n; j++) {
//                 mul *= nums[j];
//                 maxi=Math.max(maxi, mul); 
//             }
//         }
//         return maxi;
//     }
// }

class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);
            res = Math.max(res, maxProd);
        }
        return res;
    }
}

public class maximum_product_subarray_in_an_array {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,0};
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(nums));
    }
}

// Input: Nums = [1,2,3,4,5,0]
// Output: 120
// Explanation: 
// In the given array, 1×2×3×4×5 gives maximum product value.
// Input: Nums = [1,2,-3,0,-4,-5]
// Output: 20
// Explanation: 
// In the given array, (-4)×(-5) gives maximum product value.