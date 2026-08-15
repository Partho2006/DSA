import java.util.*;

class Solution {
    public List<Integer> majority(int[] arr) {
        int n=arr.length;
        int c1=0, c2=0;
        int el1=Integer.MIN_VALUE, el2=Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(c1==0 && el2!=arr[i]) {
                c1=1;
                el1=arr[i];
            } else if(c2==0 && el1!=arr[i]) {
                c2=1;
                el2=arr[i];
            } else if(arr[i] == el1) {
                c1++;
            } else  if(arr[i] == el2) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1=0; c2=0;
        for(int i=0; i<n; i++) {
            if(arr[i] == el1) c1++;
            else if(arr[i] == el2) c2++;
        }
        int N=n/3+1;
        List<Integer> result=new ArrayList<>();
        if (c1 >= N) result.add(el1);
        if (c2 >= N && el1 != el2) result.add(el2);
        return result;
    }
}

public class Majority_II {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 1, 3, 2 };      
        Solution obj = new Solution();
        List<Integer> maj= obj.majority(arr);
        System.out.print("Majority element: ");
        for(int i : maj) {
            System.out.print(i + ", ");
        }
    }
}
