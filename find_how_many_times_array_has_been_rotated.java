import java.util.*;

class Solution {
    public int findRotationCount(int[] arr) {
        int n = arr.length;
        int low=0, high=n-1;
        while (low<high) {
            int mid=low+(high-low)/2;
            if(arr[mid] > arr[high]) {
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    } 
}

public class find_how_many_times_array_has_been_rotated {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2}; 
        Solution obj = new Solution();
        int r = obj.findRotationCount(arr);  
        System.out.println("The num of times array has been rotated: " + r);
        
    }
}