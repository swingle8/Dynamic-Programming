// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDiffernce(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDiffernce(int arr[], int n) { 
        int sum = 0;
        for (int i = 0 ; i < arr.length ; i++)
            sum += arr[i];
        boolean [][] dp = new boolean[arr.length+1][sum+1];
        dp [0][0] = true;
        for (int i = 0 ;  i <= arr.length ; i++) {
            for (int j = 0 ; j <= sum ; j++) {
                if (j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (j < arr[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
            }
        }
        
        int i = 0;
        for (i = sum/2 ; i >= 0 ; i--) {
            boolean curr = dp[arr.length][i];
            if (curr)
                break;
        }
        
        int anotherSum = sum - i;
        return Math.abs (anotherSum - i);
        
	}
}
