import java.util.*;

class Solution {
    public int countSubarrays(int[] A, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int prefixXor = 0;
        int count = 0;

        for (int num : A) {
            prefixXor ^= num;
            int target = prefixXor ^ k;
            if (freq.containsKey(target)) {
                count += freq.get(target);
            }
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        System.out.println(freq+", ");
        return count;
    }
}

public class count_number_of_subarrays_with_given_xor_k {
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 6, 4};
        int k = 6;
        Solution sol = new Solution();
        System.out.println("Number of subarrays: "+sol.countSubarrays(A, k));
    }
}
