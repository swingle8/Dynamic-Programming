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
	    return getSubsetCount (arr, n-1, sum);
	}
	
	public int getSubsetCount (int [] arr, int n, int sum) {
	    if (sum == 0)
	        return 1;

	    if (n < 0)
	        return 0;

	    if (sum < arr[n])
	        return getSubsetCount (arr, n-1, sum);
	    
	    return (getSubsetCount (arr, n-1, sum) + getSubsetCount (arr, n-1, sum-arr[n]));
	}
}