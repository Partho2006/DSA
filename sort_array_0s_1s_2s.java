import java.util.*;

class Solution {
    public void sort (int[] arr) {
        int n=arr.length;
        int low=0;
        int mid=0;
        int high=n-1;
        while(mid <= high){
            if (arr[mid] == 0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else {
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            } 
        }
    }
}
public class sort_array_0s_1s_2s {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[10];
        System.out.println("Enter 10 elements: ");
        for(int i=0; i<10; i++) {
            arr[i]=sc.nextInt();
        }
        Solution obj=new Solution();
        obj.sort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}