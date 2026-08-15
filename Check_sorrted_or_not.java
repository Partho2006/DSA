import java.util.*;
class Sol {
    public static boolean sorted (int[] arr, int n) {
        for (int i=0; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
public class Check_sorrted_or_not {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of terms: ");
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Sol obj = new Sol();
        System.out.println(obj.sorted(arr, n) ? "true" : "false");
        sc.close();
    }
}