// 49. Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] cnt = new int[26];
            for(char c : s.toCharArray()) {
                cnt[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : cnt) {
                sb.append('#');
                sb.append(i);
            }
            String Key = sb.toString();
            if (!map.containsKey(Key)) {
                map.put(Key, new ArrayList<String>());
            }
            map.get(Key).add(s);
        }
        return new ArrayList(map.values());
    }
} 

// Time Complexity: O(N × K)
// Space Complexity: O(N × K)
// Where N = number of strings, K = max length of a string



// ## 🧠 Goal of the Program

// ### **STEP 1 — Create a Map**
// Make a HashMap to store:

// **Key → Letter pattern**
// **Value → List of words with that pattern**

// ---

// ### **STEP 2 — Pick One Word at a Time**

// Loop through each word in the array.

// ---

// ### **STEP 3 — Count Letters**

// Make an array of size 26 (for a–z).

// For each letter in the word:

// * Find its position (`c - 'a'`)
// * Increase its count

// This gives us how many times each letter appears.

// ---

// ### **STEP 4 — Build a Unique Key**

// Turn the letter counts into a string.

// Example for `"eat"`:

// a=1, e=1, t=1 →
// Key becomes something like:

// `#1#0#0#0#1#0...#1...`

// All anagrams will make the **same key**.

// ---

// ### **STEP 5 — Store Word in Map**

// If the key is new:

// * Create a new list in the map

// Then:

// * Add the word to that key’s list

// ---

// ### **STEP 6 — Repeat**

// Do Steps 2–5 for all words.

// ---

// ### **STEP 7 — Return Answer**

// Return all the lists from the map.

// These lists are your grouped anagrams.
