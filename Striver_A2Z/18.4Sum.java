// 18. 4Sum
// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] +
                               arr[left] + arr[right];

                    if (sum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j],
                                              arr[left], arr[right]));

                        while (left < right && arr[left] == arr[left + 1]) left++;
                        while (left < right && arr[right] == arr[right - 1]) right--;

                        left++;
                        right--;
                    }
                    else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return ans;
    }
}

// Time Complexity: O(N^3) 
// Space Complexity: O(1)

// Sort the array first.
// Use the first loop to pick the first number. Skip it if it is the same as the previous one to avoid duplicates.
// Inside it, use the second loop to pick the second number. Also skip it if it repeats the previous one.
// Set two pointers: one just after the second number (left pointer) and one at the end of the array (right pointer).
// While the left pointer is before the right pointer, calculate the total of the four chosen numbers.
// If the total equals the target, save the quadruplet, then move both pointers while skipping duplicate numbers.
// If the total is less than the target, move the left pointer one step forward to increase the total.
// If the total is greater than the target, move the right pointer one step backward to reduce the total.
// After all loops finish, return the list of unique groups of four numbers.