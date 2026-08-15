import java.util.*;

class Solution {
    public int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;  

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;        
                high = mid - 1;   
            } else {
                low = mid + 1;    
            }
        }
        return ans;  
    }
    public int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;  

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;        
                high = mid - 1;   
            } else {
                low = mid + 1;    
            }
        }
        return ans;  
    }
}

public class implement_lower_upper_bound {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19}; 
        int x = 9;
        Solution finder = new Solution();
        int ub = finder.upperBound(arr, x);  
        System.out.println("The upper bound is the index: " + ub);
        int lb = finder.lowerBound(arr, x);  
        System.out.println("The lower bound is the index: " + lb);
    }
}