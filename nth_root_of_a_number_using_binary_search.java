class Solution {
    public int nthRoot(int n, int m) {
        int low=0, high=m;
        while (low <= high) {
            int mid=low+(high-low)/2;
            long ans=1;
            for(int i=0; i<n; i++) {
                ans *= mid;
                if(ans>m) break;
            }
            if(ans == m) return mid;
            if(ans < m) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}

public class nth_root_of_a_number_using_binary_search {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int result = obj.nthRoot(3, 27);
        System.out.println(result);
    }
}

// Input: N = 3, M = 27
// Output: 3
// Explanation: The cube root of 27 is equal to 3.
// Input : N = 4, M = 69
// Output: -1
// Explanation : The 4th root of 69 does not exist. So, the answer is -1.