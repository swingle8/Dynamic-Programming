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
        //int i = price.length;
        //return getmaxPrice (price, n, i-1);
        int [][] dp = new int [n+1][n+1];
        
        for (int i = 0 ; i <= n ; i++) {
            for (int j = 0 ; j <= n ; j++) {
                if (j == 0)
                    dp[i][j] = 0;
                else if (i == 0)
                    dp[i][j] = -1;
                else if (j < i)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max ((price[i-1] + dp[i][j-i]), dp[i-1][j]);
            }
        }
        return dp[n][n];
    }
}