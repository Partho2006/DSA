// 75. Sort Colors
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;
    while (mid <= high) {
        if (nums[mid] == 0) {
            int tmp = nums[low];
            nums[low++] = nums[mid];
            nums[mid++] = tmp;
        } else if (nums[mid] == 1) {
            mid++;
        } else {
            int tmp = nums[mid];
            nums[mid] = nums[high];
            nums[high--] = tmp;
        }
    }
}

// Step 1: Create three pointers
// low = 0, mid = 0, high = nums.length − 1
// These divide the array into regions:
// 0s on the left, 1s in the middle, 2s on the right.

// Step 2: Start a loop that runs while mid <= high.

// Step 3: Check the value at nums[mid].

// Step 4: If nums[mid] is 0
// Swap nums[mid] with nums[low].
// Increase both low and mid by 1.
// Reason: 0 belongs to the left section.

// Step 5: If nums[mid] is 1
// Just move mid forward by 1.
// Reason: 1 belongs in the middle, already correct.

// Step 6: If nums[mid] is 2
// Swap nums[mid] with nums[high].
// Decrease high by 1.
// Do NOT increase mid yet, because the swapped value needs to be checked.

// Step 7: Repeat until mid passes high.

// Step 8: At the end:
// All 0s are before low,
// All 1s are between low and high,
// All 2s are after high.


// Time Complexity: O(n)
// Space Complexity: O(1)