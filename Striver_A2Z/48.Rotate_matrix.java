// 48. Rotate Image
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}

// Time complexity: O(n^2)
// Space complexity: O(1)


// ## Rotate Matrix (90° Clockwise) 

// Goal:
// Rotate a square matrix 90 degrees clockwise **in-place**.

// This is done in **2 steps**:

// ---

// ## Step 1: Transpose the Matrix

// Transpose means:
// Convert rows into columns.

// For every `i` and `j` (where `j > i`):
// Swap:

// ```
// matrix[i][j] ↔ matrix[j][i]
// ```

// This flips the matrix across its diagonal.

// Example:

// Before transpose:

// ```
// 1 2 3
// 4 5 6
// 7 8 9
// ```

// After transpose:

// ```
// 1 4 7
// 2 5 8
// 3 6 9
// ```

// ---

// ## Step 2: Reverse Each Row

// Now reverse every row of the matrix.

// For each row:

// * Take two pointers `l = 0`, `r = n-1`
// * Swap elements while `l < r`
// * Move inward

// After reversing rows:

// ```
// 7 4 1
// 8 5 2
// 9 6 3