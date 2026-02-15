// 118. Pascal's Triangle
// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> dummyRow = new ArrayList<>();
            dummyRow.add(0);
            dummyRow.addAll(res.get(res.size() - 1));
            dummyRow.add(0);
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < dummyRow.size() - 1; j++) {
                row.add(dummyRow.get(j) + dummyRow.get(j + 1));
            }

            res.add(row);
        }

        return res;        
    }
}

// Time complexity: O(n^2)
// Space complexity: O(n^2)


// Alright, let’s make this **very clear and visual**.

// This code generates **Pascal’s Triangle**.

// In Pascal’s Triangle:

// * First and last element of every row = 1
// * Every middle element = sum of two numbers above it

// Example:

// ```
// Row 0:        [1]
// Row 1:       [1, 1]
// Row 2:      [1, 2, 1]
// Row 3:     [1, 3, 3, 1]
// Row 4:    [1, 4, 6, 4, 1]
// ```

// ---

// # What This Code Is Doing

// ### 1️⃣ Create Result List

// ```
// List<List<Integer>> res = new ArrayList<>();
// ```

// This stores all rows.

// ---

// ### 2️⃣ Add First Row

// ```
// res.add(List.of(1));
// ```

// Pascal’s triangle always starts with:

// ```
// [1]
// ```

// ---

// ### 3️⃣ Loop for Remaining Rows

// ```
// for (int i = 0; i < numRows - 1; i++)
// ```

// We already added first row,
// so we generate the rest.

// ---

// ## 🔥 Core Trick (Important Part)

// To generate a new row, the code:

// ### Step A: Add 0 at beginning and end

// ```
// dummyRow.add(0);
// dummyRow.addAll(previous row);
// dummyRow.add(0);
// ```

// Why add zeros?

// Because it makes calculation easy.

// ---

// ### Example

// Suppose previous row is:

// ```
// [1, 3, 3, 1]
// ```

// We convert it into:

// ```
// [0, 1, 3, 3, 1, 0]
// ```

// Now look what happens if we add neighbors:

// ```
// 0+1 = 1
// 1+3 = 4
// 3+3 = 6
// 3+1 = 4
// 1+0 = 1
// ```

// New row:

// ```
// [1, 4, 6, 4, 1]
// ```

// That’s exactly Pascal’s rule.

// ---

// ### 4️⃣ Build New Row

// ```
// for (int j = 0; j < dummyRow.size() - 1; j++)
// ```

// Add:

// ```
// dummyRow[j] + dummyRow[j+1]
// ```

// This creates the next row.

// ---

// ### 5️⃣ Add New Row to Result

// ```
// res.add(row);
// ```

// Repeat until all rows are created.

// ---

// # Why This Works

// Pascal’s rule:

// ```
// current[i] = previous[i-1] + previous[i]
// ```

// Adding 0 at both ends handles edge cases automatically.

// ---

// # Simple Summary

// Start with [1]
// Add 0 at both ends
// Add adjacent numbers
// Store new row
// Repeat

