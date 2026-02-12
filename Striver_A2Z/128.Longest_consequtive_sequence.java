// 128. Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

// Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;        
    }
}

// Time complexity: O(n)
// Space complexity: O(n)


// Longest Consecutive Sequence 
// Goal:
// Find the length of the longest consecutive numbers sequence.

// Step 1:
// Store all numbers in a HashSet.
// This allows fast checking if a number exists.

// Step 2:
// Take a variable longest = 0 to store the maximum length.

// Step 3:
// Loop through each number in the set.

// For each number:

// Check if (num - 1) is NOT present in the set.
// If not present, this number is the start of a sequence.

// Step 4:
// Start counting from that number.

// Set length = 1.

// While (num + length) exists in the set, increase length.

// Step 5:
// Update longest with the maximum value.

// Step 6:
// Return longest.