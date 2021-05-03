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
        
        int currentSum = 0;
        return getMinDiff (arr, n-1, currentSum, sum);
	}
	
	public int getMinDiff (int [] arr, int i, int currSum, int sum) {
	    if (i < 0) {
	        int val = sum - currSum;
	        return Math.abs (currSum - val);
	    }
	    
	    return Math.min (getMinDiff (arr, i-1, currSum, sum), getMinDiff (arr, i-1, currSum + arr[i], sum));
	}
}
