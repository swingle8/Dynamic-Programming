// { Driver Code Starts
import java.util.Scanner;
class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            GFG obj = new GFG();
            System.out.println(obj.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class GFG {
    public int cutRod(int price[], int n) {
        int i = price.length;
        return getmaxPrice (price, n, i-1);
    }
    
    
    //brite-force approach
    public int getmaxPrice (int [] price, int length, int i) {
        if (length == 0)
            return 0;
        if (i < 0)
            return -1;
        if (length < i+1)
            return getmaxPrice (price, length, i-1);
        else
            return Math.max (getmaxPrice (price, length-i-1, i) + price[i], getmaxPrice (price, length, i-1));
    }
}