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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) { 
	    int dp[][] = new int[arr.length+1][sum+1];
	    dp[0][0] = 1;
	    int mod = 1000000007;
	    for (int i = 0 ; i <= arr.length ; i++) {
	        for (int j = 0 ; j <= sum ; j++) {
	            if (i == 0 && j != 0)
	                dp[i][j] = 0;
	            else if (j == 0)
	                dp[i][j] = 1;
	            else if (j < arr[i-1])
	                dp[i][j] = dp[i-1][j];
	            else
	                dp[i][j] = (dp[i-1][j] + dp[i-1][j - arr[i-1]])%mod;
	        }
	    }
	    
	    return dp[arr.length][sum];
	}
}