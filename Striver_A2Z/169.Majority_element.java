// 169. Majority Element
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Example 1:
// Input: nums = [3,2,3]
// Output: 3

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            
            if (i == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}

// ✅ Algorithm: Boyer–Moore Voting (Step Explanation for Writing)
// Goal: Find the element that appears more than ⌊n/2⌋ times.

// 🔹 Step 1: Initialize Variables

// Take count = 0
// Take candidate = 0 (any initial value)

// 🔹 Step 2: Traverse the Array

// For each element i in the array:

// Step 2.1

// If count == 0
// → Set candidate = i

// Step 2.2

// If i == candidate
// → Increase count by 1

// Else
// → Decrease count by 1

// 🔹 Step 3: Return Candidate

// After the loop ends, return candidate.