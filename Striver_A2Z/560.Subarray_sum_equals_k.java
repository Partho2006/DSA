// 560. Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2
 
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)


// ## Subarray Sum Equals K  --  *prefix sum algo* used her

// Goal:
// Count how many subarrays have sum equal to `k`.

// ---

// ### Step 1

// Create a HashMap.
// It stores:
// `prefixSum → how many times it has appeared`

// Put:

// ```
// map.put(0, 1);
// ```

// This means: sum 0 has appeared once (before starting).

// ---

// ### Step 2

// Take:

// * `sum = 0` (running sum)
// * `count = 0` (answer)

// ---

// ### Step 3

// Loop through the array.

// For each element:

// 1. Add element to running sum:

//    ```
//    sum = sum + nums[i]
//    ```

// 2. Check if `(sum - k)` exists in map.

//    If yes →
//    Increase `count` by how many times `(sum - k)` appeared.

// 3. Store current sum in map:

//    ```
//    map.put(sum, map.getOrDefault(sum, 0) + 1)
//    ```

// ---

// ### Why `(sum - k)` ?

// If:

// ```
// current sum = S
// ```

// And earlier prefix sum was:

// ```
// S - k
// ```

// Then:

// ```
// S - (S - k) = k
// ```

// That means subarray between them has sum = k.

// ---

// ### Example

// nums = [1,1,1], k = 2

// Subarrays with sum 2:
// [1,1] (first two)
// [1,1] (last two)

// Answer = 2

// ---

// ### Simple Idea

// Keep track of prefix sums.
// If previous sum difference equals `k`,
// we found a valid subarray.