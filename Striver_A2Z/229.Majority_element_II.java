// 229. Majority Element II
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Example 1:
// Input: nums = [3,2,3]
// Output: [3]

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i]; 
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i]; 
            } else if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++; 
            } else {
                cnt1--; 
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0; 
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++; 
            if (nums[i] == el2) cnt2++;
        }

        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>(); 
        if (cnt1 >= mini) result.add(el1);
        if (cnt2 >= mini && el1 != el2) result.add(el2);

        return result;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)

// Boyer-Moore Majority Voting Solution :
// Initialize four variables: cnt1 and cnt2 for tracking the counts of elements, and el1 and el2 for storing the potential majority elements.
// Traverse through the given array:
//      1. If cnt1 is 0 and the current element is not equal to el2, set el1 to the current element and increment cnt1 by 1.
//      2. If cnt2 is 0 and the current element is not equal to el1, set el2 to the current element and increment cnt2 by 1.
//      3. If the current element is equal to el1, increment cnt1 by 1.
//      4. If the current element is equal to el2, increment cnt2 by 1.
//      5. In all other cases, decrease cnt1 and cnt2 by 1.
// After processing all elements, el1 and el2 should be the candidate elements for majority. To confirm:
//       1. Use another loop to manually check the counts of el1 and el2 in the array.
//       2. If either el1 or el2's count is greater than floor(N/3), it is considered a valid majority element.
