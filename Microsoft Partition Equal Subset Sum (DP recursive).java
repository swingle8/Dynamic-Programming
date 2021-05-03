// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for (int i = 0 ; i < N ; i ++)
            sum += arr[i];
        
         if (sum%2 != 0)
            return 0;
         boolean [][] dp = new boolean[arr.length+1][sum/2+1];
         if (hasSum (arr, N-1, sum/2, dp))
            return 1;
        return 0;
    }
    
    static boolean hasSum (int [] arr, int n, int sum, boolean [][] dp) {
        if (sum == 0)
            return true;
        if (n < 0)
            return false;
        if (dp[n+1][sum])
            return dp[n+1][sum];
        
        if (sum < arr[n])
            dp[n+1][sum] = hasSum(arr, n-1, sum, dp);
        else
            dp[n+1][sum] = (hasSum (arr, n-1, sum, dp) || hasSum (arr, n-1, sum-arr[n], dp));
        return dp[n+1][sum];
    }
}