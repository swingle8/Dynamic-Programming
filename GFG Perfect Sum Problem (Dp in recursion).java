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
	    return getSubsetCount (arr, n-1, sum, dp);
	}
	
	public int getSubsetCount (int [] arr, int n, int sum, int [][] dp) {
	   if (sum == 0)
	        return 1;
	    
	    if (n < 0) 
	        return 0;
	    
        if (dp[n+1][sum] > 0)
            return dp[n+1][sum];
	    if (sum < arr[n])
	        dp[n+1][sum] = getSubsetCount (arr, n-1, sum, dp);
	    else
	        dp[n+1][sum] = (getSubsetCount (arr, n-1, sum, dp) + getSubsetCount (arr, n-1, sum-arr[n], dp));
	
	    return dp[n+1][sum];
	}
}